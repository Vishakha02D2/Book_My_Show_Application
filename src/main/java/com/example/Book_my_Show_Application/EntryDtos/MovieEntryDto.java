package com.example.Book_my_Show_Application.EntryDtos;

import com.example.Book_my_Show_Application.Enums.Genre;
import com.example.Book_my_Show_Application.Enums.Language;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class MovieEntryDto {

    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;

}