package com.example.Book_my_Show_Application.Entities;

import com.example.Book_my_Show_Application.Enums.SeatType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="showseats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;

    private int price; //price of CLASSIC Seat for that particualr

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}