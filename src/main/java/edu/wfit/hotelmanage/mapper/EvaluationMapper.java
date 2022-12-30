package edu.wfit.hotelmanage.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.wfit.hotelmanage.pojo.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yuo
* @description 针对表【t_evaluation】的数据库操作Mapper
* @createDate 2022-12-19 23:49:25
* @Entity edu.wfit.hotelmanage.pojo.Evaluation
*/
public interface EvaluationMapper extends BaseMapper<Evaluation> {


    List<Evaluation> getAll();

    int deleteByEId(@Param("eId") Integer eId);



}




