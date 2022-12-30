package edu.wfit.hotelmanage.service;

import edu.wfit.hotelmanage.pojo.Reply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_reply】的数据库操作Service
* @createDate 2022-12-30 20:57:19
*/
public interface ReplyService extends IService<Reply> {
    List<Reply> getAll();

    List<Reply> getAllByEId(Integer eId);

    void removeByEId(Integer eId);
}
