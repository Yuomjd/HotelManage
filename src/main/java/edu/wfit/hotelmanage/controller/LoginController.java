package edu.wfit.hotelmanage.controller;


import edu.wfit.hotelmanage.pojo.User;
import edu.wfit.hotelmanage.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@Controller
@RestController
public class LoginController {

    @Autowired
    public UserService userService;

    /**
     * 登录接口
     * @param map
     * @return  登录用户的数据与状态码
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody() HashMap<String,String> map){
        log.info("登录请求进来了...");
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        User user = userService.getUser(userName, passWord);
        ResponseEntity<User> responseEntity;
        if(user != null){
            responseEntity= new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            responseEntity= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/index2")
    public String index(){
        return "index2";
    }


    /**
     * 注册接口
     * @param map
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody() HashMap<String,String> map){
        log.info("注册请求进来了...");
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        ResponseEntity<User> response;
        if(!userService.existsUser(userName)){
            String email = map.get("email");
            String idCard = map.get("idCard");
            String gender = map.get("gender");
            String trueName = map.get("trueName");
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(passWord);
            user.setGender(gender);
            user.setContact(email);
            user.setIdCard(idCard);
            user.setTrueName(trueName);
//            0为普通用户 1为管理员，默认都为普通用户
            user.setUserType(0);
            userService.save(user);
            response = new ResponseEntity<>(user,HttpStatus.OK);
        }
        else{
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
