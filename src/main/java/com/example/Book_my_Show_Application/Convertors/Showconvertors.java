package com.example.Book_my_Show_Application.Convertors;

import com.example.Book_my_Show_Application.Entities.ShowEntity;
import com.example.Book_my_Show_Application.EntryDtos.ShowEntryDto;

public class Showconvertors {

    public static ShowEntity convertEntryToEntity(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowEntity.builder().showDate(showEntryDto.getLocalDate()).
                                showTime(showEntryDto.getLocalTime()).
                                showType(showEntryDto.getShowType()).build();
        return showEntity;
    }
}
