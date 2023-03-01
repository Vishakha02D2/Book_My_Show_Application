package com.example.Book_my_Show_Application.Convertors;

import com.example.Book_my_Show_Application.Entities.TicketEntity;
import com.example.Book_my_Show_Application.EntryDtos.TicketEntryDto;

public class TicketConvertors {


    public static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){

        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;

    }
}