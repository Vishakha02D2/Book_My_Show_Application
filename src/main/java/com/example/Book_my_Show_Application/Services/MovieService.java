package com.example.Book_my_Show_Application.Services;

import com.example.Book_my_Show_Application.Convertors.MovieConvertors;
import com.example.Book_my_Show_Application.Entities.MovieEntity;
import com.example.Book_my_Show_Application.Entities.TicketEntity;
import com.example.Book_my_Show_Application.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show_Application.Repositories.MovieRepository;
import com.example.Book_my_Show_Application.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TicketRepository ticketRepository;
    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{


        MovieEntity movieEntity = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";


    }
    public MovieEntity getMovie(String name){
        return movieRepository.getMovie(name);
    }
    public List<String> getMovieRating(double rate){
        return movieRepository.getMovieRating(rate);
    }

    public int getMovieRevenue(String name){
        List<TicketEntity> ticketEntityList = ticketRepository.findAll();
        int ans =0;
        for(TicketEntity ticketEntity: ticketEntityList){
            if(ticketEntity.getMovieName().equals(name)){
                ans+=ticketEntity.getTotalAmount();
            }
        }
        return ans;
    }

    public List<String> getAll( ){ //movie names

        return movieRepository.getAll();
    }


}
