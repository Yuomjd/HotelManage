package edu.wfit.hotelmanage.service;

import edu.wfit.hotelmanage.pojo.Room;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_room】的数据库操作Service
* @createDate 2022-12-19 23:49:14
*/
public interface RoomService extends IService<Room> {

   Room getRoomById(Integer id);

   Room getRoomByRoomNumber(String roomNumber);

   List<Room> getRoomLikeRoomNumber(Integer roomNumber);

   List<Room> getAll();

   List<Room> getAllByRoomStatus(String roomStatus);

   void insertRoom(Room room);

   void updateRoom(Room room);

   void deleteRoomByRoomId(Integer roomId);

   void updateRoomStatusByRoomId(String status,Integer roomId);

   void updateRoomStatusByRoomId(String status,List<Integer> roomIds);
}
