package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Room;
import edu.wfit.hotelmanage.service.RoomService;
import edu.wfit.hotelmanage.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return roomMapper.selectById(id);
    }

    @Override
    public Room getRoomByRoomNumber(String roomNumber) {
        QueryWrapper<Room> wrapper = new QueryWrapper<>();
        wrapper.eq("room_number",roomNumber);
        return roomMapper.selectOne(wrapper);
    }

    public List<Room> getRoomLikeRoomNumber(Integer roomNumber){
        QueryWrapper<Room> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("room_number",roomNumber);
        List<Room> rooms = roomMapper.selectList(queryWrapper);
        return  rooms;
    }

    @Override
    public List<Room> getAll() {
        return roomMapper.selectList(null);
    }

    @Override
    public List<Room> getAllByRoomStatus(String roomStatus) {
        QueryWrapper<Room> wrapper = new QueryWrapper<>();
        wrapper.eq("room_status",roomStatus);
        return roomMapper.selectList(wrapper);
    }

    @Override
    public void insertRoom(Room room) {
        roomMapper.insert(room);
    }

    @Override
    public void updateRoom(Room room) {
        UpdateWrapper<Room> wrapper = new UpdateWrapper<>();
        wrapper.eq("room_id",room.getRoomId());
        roomMapper.update(room,wrapper);
    }

    @Override
    public void deleteRoomByRoomId(Integer roomId) {
        roomMapper.deleteById(roomId);
    }

    @Override
    public void updateRoomStatusByRoomId(String roomStatus,Integer roomId) {
        roomMapper.updateRoomStatusByRoomId(roomStatus,roomId);
    }

    @Override
    public void updateRoomStatusByRoomId(String status, List<Integer> roomIds) {
        roomMapper.updateRoomStatusByRoomNumberIn(status,roomIds);
    }

}




