package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
    @Query(value = "select location, name from theaters ", nativeQuery = true)
    List<String> getAllTheaters();
    @Query(value = "select theaters.name, theaters.location, shows.show_date, shows.show_time from theaters join shows where theaters.id=shows.theater_entity_id and theaters.name=:name ", nativeQuery = true)
    List<String> shows(String name);
}