package edu.wfit.hotelmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.wfit.hotelmanage.bean.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
