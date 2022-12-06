package edu.wfit.hotelmanage;

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

}
