package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.User;
import edu.wfit.hotelmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/user")
    public ResponseEntity<List<User>> getUserList(){
        List<User> all = userService.getAll();
        ResponseEntity<List<User>> responseEntity = new ResponseEntity<>(all, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/user")
    public ResponseEntity deleteUser(@RequestBody User user){
        userService.removeById(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
