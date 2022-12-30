package edu.wfit.hotelmanage.controller;

import edu.wfit.hotelmanage.pojo.Evaluation;
import edu.wfit.hotelmanage.service.EvaluationService;
import edu.wfit.hotelmanage.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EvaluationController {

    @Autowired
    EvaluationService evaluationService;
    @Autowired
    ReplyService replyService;

    @GetMapping("/evaluation")
    public ResponseEntity<List<Evaluation>> getEvaluation(){
        List<Evaluation> all = evaluationService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    /**
     * 提交的日期需要ISO8601国际标准时间格式（如要表示北京时间2022年5月3日下午5点30分8秒，可以写成2022-05-03T17:30:08+08:00或20040503T093008+08）、时间戳格式时，
     * @param evaluation
     * @return
     */
    @PostMapping("/evaluation")
    public ResponseEntity addEvaluation(@RequestBody Evaluation evaluation){
        evaluationService.insertEvaluation(evaluation);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/evaluation")
    public ResponseEntity updateEvaluation(@RequestBody Evaluation evaluation){
        evaluationService.updateEvaluation(evaluation);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/evaluation/{eId}")
    public ResponseEntity deleteEvaluation(@PathVariable String eId){
        evaluationService.deleteEvaluation(Integer.valueOf(eId));
//        删除对应评价的回复
        replyService.removeByEId(Integer.valueOf(eId));
        return new ResponseEntity(HttpStatus.OK);
    }
}
