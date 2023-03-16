package com.example.Book_my_Show_Application.Controllers;

import com.example.Book_my_Show_Application.EntryDtos.ShowEntryDto;
import com.example.Book_my_Show_Application.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){

        try {
            showService.addShow(showEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("show added successfully", HttpStatus.CREATED);
    }

    @GetMapping("showsOfMovie")
    public List<String> showsOfMovie(@RequestParam String name){
        return showService.showsOfMovie(name);
    }
    @GetMapping("showAfter")
    public List<String> showAfter(@RequestParam LocalTime time){
        return showService.showAfter(time);
    }
}
