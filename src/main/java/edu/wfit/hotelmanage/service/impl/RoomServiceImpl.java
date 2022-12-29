package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Room;
import edu.wfit.hotelmanage.service.RoomService;
import edu.wfit.hotelmanage.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yuo
* @description 针对表【t_room】的数据库操作Service实现
* @createDate 2022-12-19 23:49:14
*/
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room>
    implements RoomService{

    @Autowired
    RoomMapper roomMapper;

    public Room getRoomById(Integer id){
        return roomMapper.getByRoomId(id).get(0);
    }
}




