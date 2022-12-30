package edu.wfit.hotelmanage.service;

import edu.wfit.hotelmanage.pojo.Evaluation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_evaluation】的数据库操作Service
* @createDate 2022-12-19 23:49:25
*/
public interface EvaluationService extends IService<Evaluation> {

    List<Evaluation> getAll();

    void insertEvaluation(Evaluation evaluation);

    void deleteEvaluation(Integer eId);

    void updateEvaluation(Evaluation evaluation);
}
