package com.example.Book_my_Show_Application.Services;


import com.example.Book_my_Show_Application.Convertors.Showconvertors;
import com.example.Book_my_Show_Application.Entities.*;
import com.example.Book_my_Show_Application.EntryDtos.ShowEntryDto;
import com.example.Book_my_Show_Application.Enums.SeatType;
import com.example.Book_my_Show_Application.Repositories.MovieRepository;
import com.example.Book_my_Show_Application.Repositories.ShowRepository;
import com.example.Book_my_Show_Application.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto)
    {
        //1. Create a showEntity
        ShowEntity showEntity = Showconvertors.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeats(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);


        movieRepository.save(movieEntity);

        theaterRepository.save(theaterEntity);

        return "The show has been added successfully";

    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){



        //Now the goal is to create the ShowSeatEntity
        //We need to set its attribute

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }

        return  seatEntityList;

    }

    public List<String> showsOfMovie(@RequestParam String name){   //giving -> show time and theater for given movie
        return showRepository.showsOfMovie(name);
    }

    public List<String> showAfter(LocalTime time){
        List<ShowEntity> showEntityList = showRepository.findAll();
        List<String> showEntityList1 = new ArrayList<>();


        for(ShowEntity showEntity: showEntityList){
            if(showEntity.getShowTime().isAfter(time)){
                MovieEntity movieEntity = movieRepository.findById(showEntity.getMovieEntity().getId()).get();
                TheaterEntity theaterEntity = theaterRepository.findById(showEntity.getTheaterEntity().getId()).get();
                showEntityList1.add(movieEntity.getMovieName()+" "+theaterEntity.getName()+" "+theaterEntity.getLocation());
            }
        }



        return showEntityList1;


    }


}