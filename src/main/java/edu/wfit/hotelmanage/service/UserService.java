package edu.wfit.hotelmanage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.bean.User;
import edu.wfit.hotelmanage.mapper.UserMapper;
import edu.wfit.hotelmanage.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IService<User> {


    @Autowired
    UserMapper userMapper;

    public User getUser(String username,String passWord){
        passWord = PasswordUtil.getPasswordBySha256(passWord);
        User user = new User(null,username,passWord);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("user_id","user_name","user_password");
        return this.getOne(wrapper);
    }

    public User getUser(String username){
        User user = new User(null,username,null);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("user_name");
        return this.getOne(wrapper);
    }

    public boolean exists(User user){
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("*");
        return userMapper.exists(wrapper);
    }
    @Override
    public boolean save(User entity) {
        entity.setUserPassword(PasswordUtil.getPasswordBySha256(entity.getUserPassword()));
        return super.save(entity);
    }
}
