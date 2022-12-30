package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.Reservation;
import edu.wfit.hotelmanage.pojo.Room;
import edu.wfit.hotelmanage.service.ReservationService;
import edu.wfit.hotelmanage.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    RoomService roomService;

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getALlReservation(){
        List<Reservation> allReservation = reservationService.getAllReservation();
        return new ResponseEntity<>(allReservation, HttpStatus.OK);
    }

    @PostMapping("/reservation")
    public ResponseEntity addReservation(@RequestBody Reservation reservation){
        reservationService.insertReservation(reservation);
        roomService.updateRoomStatusByRoomId("已预订",reservation.getRoomId());
        ResponseEntity response = new ResponseEntity(HttpStatus.OK);
        return response;
    }

    @PutMapping("/reservation")
    public ResponseEntity updateReservation(){
//        获取当前时间
        Date enddate = new Date();
        Date begindate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        try {
//            设置日期的起始时间
            begindate = dateFormat.parse("2022-01-01T00:00:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        获取已经过了退房时间的有效预订
        List<Reservation> reservations = reservationService.getReservationByDateAndStatus("有效", begindate, enddate);
        List<Integer> roomIds = new ArrayList<>();
//        如果列表为空，会发生EOF错误，添加一个0防止为空
        roomIds.add(0);
        for (Reservation reservation : reservations) {
//            将要修改为已完成的预订的房间号存取到集合中
            Integer roomId = reservation.getRoomId();
            roomIds.add(roomId);
        }
//        将已完成的订单的房间状态改为空闲
        roomService.updateRoomStatusByRoomId("空闲",roomIds);
//        将预订表中的预订改为已完成
        reservationService.updateReservationStatusByDate("已完成",begindate,enddate,"有效");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/reservation/done")
    public ResponseEntity<List<Reservation>> getDoneReservation(){
        List<Reservation> doneReservation = reservationService.getDoneReservation();
        return new ResponseEntity<>(doneReservation,HttpStatus.OK);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity updateCheckOutDateByBookId(@RequestBody()Map<String,String> map, @PathVariable String id){
        String checkOut = map.get("checkOutDate");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        Date checkOutDate;
        try {
            checkOutDate = dateFormat.parse(checkOut);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        reservationService.updateCheckOutDateById(checkOutDate, Integer.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/reservation/{id}")
    public ResponseEntity deleteByBookId(@PathVariable String id){
        reservationService.deleteByBookId(Integer.valueOf(id));
        return new ResponseEntity(HttpStatus.OK);
    }
}
