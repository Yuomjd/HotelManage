package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Reply;
import edu.wfit.hotelmanage.service.ReplyService;
import edu.wfit.hotelmanage.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yuo
* @description 针对表【t_reply】的数据库操作Service实现
* @createDate 2022-12-30 20:57:19
*/
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply>
    implements ReplyService{

    @Autowired
    ReplyMapper replyMapper;
    @Override
    public List<Reply> getAll() {
        return replyMapper.selectList(null);
    }

    @Override
    public List<Reply> getAllByEId(Integer eId) {
        return replyMapper.getAllByEId(eId);
    }

    @Override
    public void removeByEId(Integer eId) {
        replyMapper.deleteByEId(eId);
    }
}




