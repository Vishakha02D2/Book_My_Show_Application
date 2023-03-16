package com.example.Book_my_Show_Application.Controllers;

import com.example.Book_my_Show_Application.Entities.MovieEntity;
import com.example.Book_my_Show_Application.EntryDtos.MovieEntryDto;
import com.example.Book_my_Show_Application.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get")
    public MovieEntity getMovie(@RequestParam String name){

        return movieService.getMovie(name);
    }

    @GetMapping("getMovieRating") //movies equal to greater given rating
    public List<String> getMovieRating (@RequestParam double rate){
        return movieService.getMovieRating(rate);
    }

    @GetMapping("earning")   //earning of movie
    public int getMovieRevenue( @RequestParam String name){

        return movieService.getMovieRevenue(name);
    }
    @GetMapping("getAll") //all movie name lists
    public List<String> getAll( ){

        return movieService.getAll();
    }


}