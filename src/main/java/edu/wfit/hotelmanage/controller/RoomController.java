package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.Room;
import edu.wfit.hotelmanage.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RoomController {

    @Autowired
    RoomService roomService;
    @GetMapping("/home/{roomNumber}")
    public ResponseEntity<List<Room>> getRoom(@PathVariable("roomNumber")String roomNumber){
        log.info("home/roomNumber进来了...");
        List<Room> rooms = roomService.getRoomLikeRoomNumber(Integer.valueOf(roomNumber));
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Room>> getAllRoom(){
        log.info("/home进来了...");
        List<Room> all = roomService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/home/status/{roomStatus}")
    public ResponseEntity<List<Room>> getRoomByRoomStatus(@PathVariable("roomStatus") String roomStatus){
        log.info("/home/status/roomStatus进来了...");
        List<Room> rooms = roomService.getAllByRoomStatus(roomStatus);
        return new ResponseEntity<>(rooms,HttpStatus.OK);
    }

    @PostMapping("/home")
    public ResponseEntity insertRoom(@RequestBody() Room room){
        log.info("/home 添加请求进来了...");
        Room roomByRoomNumber = roomService.getRoomByRoomNumber(room.getRoomNumber());
        ResponseEntity response;
        if(roomByRoomNumber == null) {
            log.info("成功添加");
            roomService.insertRoom(room);
            response = new ResponseEntity(HttpStatus.OK);
        }
        else {
            log.info("房间号重复，添加失败");
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping("/home")
    public ResponseEntity updateRoom(@RequestBody() Room room){
        log.info("/home 修改请求进来了...");
        ResponseEntity response;
        Room roomByRoomNumber = roomService.getRoomByRoomNumber(room.getRoomNumber());
        if(roomByRoomNumber == null){
            log.info("成功修改");
            roomService.updateRoom(room);
            response = new ResponseEntity(HttpStatus.OK);
        }
        else{
            log.info("房间号重复，修改失败");
            response = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/home")
    public ResponseEntity deleteRoom(@RequestBody() Room room){
        log.info("/home 删除请求进来了..");
        roomService.deleteRoomByRoomId(room.getRoomId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
