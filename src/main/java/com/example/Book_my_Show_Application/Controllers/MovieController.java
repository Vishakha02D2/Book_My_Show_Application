package com.example.Book_my_Show_Application.Controllers;

import com.example.Book_my_Show_Application.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show_Application.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")

public class MovieController {

    @Autowired
    MovieService movieService;

    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{

            String Result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(Result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);

        }
    }
}
