package com.example.Book_my_Show_Application.Repositories;

import com.example.Book_my_Show_Application.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query(value = "select * from users where mob_no=:mob", nativeQuery = true)
    UserEntity deleteUser(String mob);
    @Query(value = "select name from users", nativeQuery = true)
    List<String> getAll();

    @Query(value = "select * from users where mob_no=:mob", nativeQuery = true)
    UserEntity findMob(String mob);
}
