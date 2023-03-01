package com.example.Book_my_Show_Application.EntryDtos;
import lombok.Data;

@Data
public class TheaterEntryDto {

    //Attributes that we require
    private String name;
    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}

