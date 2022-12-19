package edu.wfit.hotelmanage;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.wfit.hotelmanage.bean.User;
import edu.wfit.hotelmanage.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HotelManageApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        long count = userService.count();
    }

    @Test
    void testSelect(){
        User user = new User();
        user.setUserName("mjd");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        User one = userService.getOne(wrapper);
        System.out.println(one);
    }
}
