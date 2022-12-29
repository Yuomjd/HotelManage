package edu.wfit.hotelmanage.service;

import edu.wfit.hotelmanage.pojo.Room;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yuo
* @description 针对表【t_room】的数据库操作Service
* @createDate 2022-12-19 23:49:14
*/
public interface RoomService extends IService<Room> {

   Room getRoomById(Integer id);
}
