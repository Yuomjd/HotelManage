package edu.wfit.hotelmanage.mapper;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.wfit.hotelmanage.pojo.Reservation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yuo
* @description 针对表【t_reservation】的数据库操作Mapper
* @createDate 2022-12-19 23:49:19
* @Entity edu.wfit.hotelmanage.pojo.Reservation
*/
public interface ReservationMapper extends BaseMapper<Reservation> {

    List<Reservation> getByRoomId(@Param("roomId") Integer roomId);

    List<Reservation> getAllByCheckOutDateBetweenAndBookStatus(@Param("beginCheckOutDate") Date beginCheckOutDate, @Param("endCheckOutDate") Date endCheckOutDate, @Param("bookStatus") String bookStatus);

    int updateBookStatusByCheckOutDateBetweenAndBookStatus(@Param("bookStatus") String bookStatus, @Param("beginCheckOutDate") Date beginCheckOutDate, @Param("endCheckOutDate") Date endCheckOutDate, @Param("oldBookStatus") String oldBookStatus);

    List<Reservation> getByBookStatus(@Param("bookStatus") String bookStatus);

    int updateCheckOutDateByBookId(@Param("checkOutDate") Date checkOutDate, @Param("bookId") Integer bookId);
}




