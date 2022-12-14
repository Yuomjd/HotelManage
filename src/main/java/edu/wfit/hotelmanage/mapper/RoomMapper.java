package edu.wfit.hotelmanage.mapper;
import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.wfit.hotelmanage.pojo.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yuo
* @description 针对表【t_room】的数据库操作Mapper
* @createDate 2022-12-19 23:49:14
* @Entity edu.wfit.hotelmanage.pojo.Room
*/
public interface RoomMapper extends BaseMapper<Room> {

    List<Room> getByRoomId(@Param("roomId") Integer roomId);

    List<Room> getByRoomNumber(@Param("roomNumber") Integer roomNumber);

    List<Room> getAll();

    int updateRoomStatusByRoomId(@Param("roomStatus") String roomStatus, @Param("roomId") Integer roomId);

    int updateRoomStatusByRoomNumberIn(@Param("roomStatus") String roomStatus, @Param("roomIdList") Collection<Integer> roomIdList);
}




