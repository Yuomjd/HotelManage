package edu.wfit.hotelmanage.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.wfit.hotelmanage.pojo.Reply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author yuo
* @description 针对表【t_reply】的数据库操作Mapper
* @createDate 2022-12-30 20:57:19
* @Entity edu.wfit.hotelmanage.pojo.Reply
*/
public interface ReplyMapper extends BaseMapper<Reply> {
    List<Reply> getAllByEId(@Param("eId") Integer eId);

    int deleteByEId(@Param("eId") Integer eId);
}




