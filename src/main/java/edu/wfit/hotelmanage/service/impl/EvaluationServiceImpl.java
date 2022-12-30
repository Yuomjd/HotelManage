package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Evaluation;
import edu.wfit.hotelmanage.service.EvaluationService;
import edu.wfit.hotelmanage.mapper.EvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_evaluation】的数据库操作Service实现
* @createDate 2022-12-19 23:49:25
*/
@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationMapper, Evaluation>
    implements EvaluationService{


    @Autowired
    EvaluationMapper evaluationMapper;
    @Override
    public List<Evaluation> getAll() {
        return evaluationMapper.getAll();
    }

    @Override
    public void insertEvaluation(Evaluation evaluation) {
        evaluationMapper.insert(evaluation);
    }

    @Override
    public void deleteEvaluation(Integer eid) {
        evaluationMapper.deleteByEId(eid);
    }

    @Override
    public void updateEvaluation(Evaluation evaluation) {
        evaluationMapper.updateById(evaluation);
    }
}




