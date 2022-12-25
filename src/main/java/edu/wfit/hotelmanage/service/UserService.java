package edu.wfit.hotelmanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import edu.wfit.hotelmanage.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends IService<User> {

    User getUser(String userName, String passWord);

    boolean existsUser(String userName);

    boolean save(User user);

    List<User> getAll();
}
