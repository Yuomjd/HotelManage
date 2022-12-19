package edu.wfit.hotelmanage.mapper;
import org.apache.ibatis.annotations.Param;

import edu.wfit.hotelmanage.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-12-19 23:31:58
* @Entity edu.wfit.hotelmanage.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByUserId(@Param("userId") Integer userId);

    
    List<User> findAll();
}




