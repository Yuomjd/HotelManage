package edu.wfit.hotelmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wfit.hotelmanage.bean.User;
import edu.wfit.hotelmanage.service.UserService;
import edu.wfit.hotelmanage.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        User user = userService.getUser(userName, passWord);
        ResponseEntity<User> responseEntity;
        if(userService.exists(user)){
            responseEntity= new ResponseEntity<>(user, HttpStatus.OK);
        }
        else {
            responseEntity= new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
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
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        ResponseEntity<User> response;
        if(!userService.exists(new User(null,userName,null))){
            User user = new User(null,userName,passWord);
            userService.save(user);
            response = new ResponseEntity<>(user,HttpStatus.OK);
        }
        else{
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
