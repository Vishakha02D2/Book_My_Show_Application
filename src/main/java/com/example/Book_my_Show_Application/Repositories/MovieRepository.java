package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
}