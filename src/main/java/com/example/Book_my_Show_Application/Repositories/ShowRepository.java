package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
    @Query(value = "select shows.show_date, shows.show_time, shows.show_type, theaters.name,theaters.location from shows join theaters where shows.movie_entity_id=theaters.id && shows.movie_entity_id=(select id from movies where movie_name=:name)", nativeQuery = true)
    List<String> showsOfMovie(String name);

}
