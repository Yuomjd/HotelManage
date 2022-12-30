package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.Reply;
import edu.wfit.hotelmanage.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    ReplyService replyService;
    @GetMapping("/reply")
    public ResponseEntity<List<Reply>> getAll(){
        List<Reply> all = replyService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/reply/{replyId}")
    public ResponseEntity<Reply> getReplyById(@PathVariable String replyId){
        Reply byId = replyService.getById(replyId);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }

    @GetMapping("/reply/e/{eId}")
    public ResponseEntity<List<Reply>> getReplyByEId(@PathVariable String eId){
        List<Reply> allByEId = replyService.getAllByEId(Integer.valueOf(eId));
        return new ResponseEntity<>(allByEId,HttpStatus.OK);
    }

    @PostMapping("/reply")
    public ResponseEntity addReply(@RequestBody Reply reply){
        replyService.save(reply);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/reply")
    public ResponseEntity updateReply(@RequestBody Reply reply){
        replyService.updateById(reply);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/reply/{replyId}")
    public ResponseEntity deleteReply(@PathVariable Integer replyId){
        replyService.removeById(replyId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
