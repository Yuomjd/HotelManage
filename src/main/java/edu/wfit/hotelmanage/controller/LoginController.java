package edu.wfit.hotelmanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wfit.hotelmanage.bean.User;
import edu.wfit.hotelmanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Map<String,Object>> register(@RequestBody() HashMap<String,String> map){
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        User user = new User(null,userName,passWord);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("username","password");
        User one = userService.getOne(wrapper);

        ResponseEntity<Map<String,Object>> responseEntity;
        if(one != null){
            responseEntity= new ResponseEntity(one, HttpStatus.OK);
        }
        else {
            responseEntity= new ResponseEntity(one, HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @GetMapping("/index2")
    public String index(){
        return "index2";
    }


    /**
     * 注册
     * @param map
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody() HashMap<String,String> map){
        String userName = map.get("userName");
        String passWord = map.get("passWord");
        User user = new User(null,userName,passWord);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("username");
        User one = userService.getOne(wrapper);
        ResponseEntity response;
        if(one == null){
            userService.save(user);
            response = new ResponseEntity(HttpStatus.OK);
        }
        else{
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
