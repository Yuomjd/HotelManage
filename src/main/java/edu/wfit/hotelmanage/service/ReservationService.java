package edu.wfit.hotelmanage.service;

import edu.wfit.hotelmanage.pojo.Reservation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
* @author yuo
* @description 针对表【t_reservation】的数据库操作Service
* @createDate 2022-12-19 23:49:19
*/
public interface ReservationService extends IService<Reservation> {

    List<Reservation> getAllReservation();

    void insertReservation(Reservation reservation);

    void updateReservationStatusByDate(String newStatus, Date beginTime, Date endTime, String bookStatus);

    List<Reservation> getReservationByDateAndStatus(String status,Date beginTime,Date endTime);

    List<Reservation> getDoneReservation();

    List<Reservation> getPlanReservation();

    void updateCheckOutDateById(Date checkOutDate,Integer bookId);

    void deleteByBookId(Integer id);

    List<Reservation> getReservationByStatus(String status);
}
