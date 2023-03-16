package com.example.Book_my_Show_Application.Services;


import com.example.Book_my_Show_Application.Convertors.UserConvertor;
import com.example.Book_my_Show_Application.Entities.UserEntity;
import com.example.Book_my_Show_Application.EntryDtos.UserEntryDto;
import com.example.Book_my_Show_Application.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto)throws Exception,NullPointerException{

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);

        return "User Added successfully";

    }

    public String deleteUser(String mob){
        UserEntity userEntity = userRepository.deleteUser(mob);
        if(userEntity==null) return "User not found";
        userRepository.delete(userEntity);
        return "Deleted successfully";
    }
    public List<String> getAll() {
        return userRepository.getAll();
    }

    public String updateAddress(String mob, String address){
        UserEntity userEntity = userRepository.findMob(mob);
        userEntity.setAddress(address);
        userRepository.save(userEntity); //new address saved
        return "Your address has been updated";
    }

}