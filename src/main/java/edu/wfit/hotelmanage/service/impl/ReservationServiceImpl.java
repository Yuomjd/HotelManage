package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Reservation;
import edu.wfit.hotelmanage.service.ReservationService;
import edu.wfit.hotelmanage.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author yuo
* @description 针对表【t_reservation】的数据库操作Service实现
* @createDate 2022-12-19 23:49:19
*/
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
    implements ReservationService{

    @Autowired
    ReservationMapper reservationMapper;


    @Override
    public List<Reservation> getAllReservation() {
        return reservationMapper.selectList(null);
    }

    @Override
    public void insertReservation(Reservation reservation) {
        reservationMapper.insert(reservation);
    }


    /**
     * 根据当前时间，更改已经完成了的预订的状态为已完成
     * @param bookStatus
     * @param beginTime
     * @param endTime
     * @param newStatus
     */
    @Override
    public void updateReservationStatusByDate(String newStatus, Date beginTime, Date endTime, String bookStatus) {
        reservationMapper.updateBookStatusByCheckOutDateBetweenAndBookStatus(newStatus,beginTime,endTime,bookStatus);
    }

    @Override
    public List<Reservation> getReservationByDateAndStatus(String status, Date beginTime, Date endTime) {
        return reservationMapper.getAllByCheckOutDateBetweenAndBookStatus(beginTime,endTime,status);
    }

    @Override
    public List<Reservation> getDoneReservation() {
        return reservationMapper.getByBookStatus("已完成");
    }

    @Override
    public List<Reservation> getPlanReservation() {
        return reservationMapper.getByBookStatus("有效");
    }

    @Override
    public void updateCheckOutDateById(Date checkOutDate, Integer bookId) {
        reservationMapper.updateCheckOutDateByBookId(checkOutDate,bookId);
    }

    @Override
    public void deleteByBookId(Integer id) {
        reservationMapper.deleteById(id);
    }
}




