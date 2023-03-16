package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    //@Query(value = "select * from transactions where book_id=:bookId and card_id=:cardId and is_issue_operation=true",
    //      nativeQuery = true)
    //List<Transactions> getTransactionsForBookAndCard(int bookId,int cardId); //always return Entity;
    @Query(value= "select * from movies where movie_name=:name", nativeQuery = true) //finding name of movie from table without id
    MovieEntity getMovie(String name);
    @Query(value= "select movie_name from movies where ratings>=:rate", nativeQuery = true) //movies name list above given rating
    List<String> getMovieRating(double rate);
    @Query(value = "select movie_name from movies", nativeQuery = true)
    List<String> getAll();
}