package com.example.Book_my_Show_Application.Services;

import com.example.Book_my_Show_Application.Convertors.MovieConvertors;
import com.example.Book_my_Show_Application.Entities.MovieEntity;
import com.example.Book_my_Show_Application.EntryDtos.MovieEntryDto;

import com.example.Book_my_Show_Application.Repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{


        MovieEntity movieEntity = MovieConvertors.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";


    }

}
