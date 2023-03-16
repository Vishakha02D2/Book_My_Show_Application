package com.example.Book_my_Show_Application.Controllers;

import com.example.Book_my_Show_Application.EntryDtos.TicketEntryDto;
import com.example.Book_my_Show_Application.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<String> addTicket(@RequestBody TicketEntryDto ticketEntryDto){

        try {
            ticketService.addTicket(ticketEntryDto);
        }catch (Exception e){
            return new ResponseEntity<>("Ticket booked successfully", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Ticket could not be booked", HttpStatus.BAD_REQUEST);
    }
    @PutMapping("cancel") //cancel the ticket from id
    public String cancelTicket(int id ){
        return ticketService.cancelTicket(id);
    }
}
