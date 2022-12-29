package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.Room;
import edu.wfit.hotelmanage.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RoomController {

    @Autowired
    RoomService roomService;
    @GetMapping("/home/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable("id")String id){
        log.info("home进来..");
        Integer id1 = Integer.valueOf(id);
        Room room = roomService.getRoomById(id1);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }
}
