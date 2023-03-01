package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {

}