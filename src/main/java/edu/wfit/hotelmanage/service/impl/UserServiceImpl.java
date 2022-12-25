package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.User;
import edu.wfit.hotelmanage.service.UserService;
import edu.wfit.hotelmanage.mapper.UserMapper;
import edu.wfit.hotelmanage.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-12-19 23:31:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    UserMapper userMapper;
    public User getUser(String userName, String passWord){
        passWord = PasswordUtil.getPasswordByMD5(passWord);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userName).eq("user_password",passWord);
        User one = this.getOne(wrapper);
        return one;
    }

    public User getUser(String userName){
        User user = new User();
        user.setUserName(userName);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        wrapper.select("user_name");
        return this.getOne(wrapper);
    }


    public boolean existsUser(String userName){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_name").eq("user_name",userName);
        return userMapper.exists(wrapper);
    }

    /**
     * 按照传入的用户对象进行存储，会调使用MD5算法进行密码加密
     *
     * @param entity 实体对象
     * @return
     */
    @Override
    public boolean save(User entity) {
        entity.setUserPassword(PasswordUtil.getPasswordByMD5(entity.getUserPassword()));
        return super.save(entity);
    }

    @Override
    public List<User> getAll() {
        return userMapper.findAll();
    }
}




