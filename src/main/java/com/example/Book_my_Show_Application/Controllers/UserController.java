package com.example.Book_my_Show_Application.Controllers;

import com.example.Book_my_Show_Application.EntryDtos.UserEntryDto;
import com.example.Book_my_Show_Application.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto){

        try{
            String response = userService.addUser(userEntryDto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);

        }catch (Exception e){

            String result = "User could not be added";
            return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("delete") //delete wrt mobile
    public String deleteUser(@RequestParam String mob){
        return userService.deleteUser(mob);
    }

    @PutMapping("updateAddress") //update address wrt mobNo
    public ResponseEntity<String> updateAddress(@RequestParam String mobNo , @RequestParam String address){
        try {
            String response = userService.updateAddress(mobNo, address);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (Exception e){
            String result = "User could not be updated";
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getAll")
    public List<String> getAll() {
        return userService.getAll();
    }


}
