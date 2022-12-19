package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Reservation;
import edu.wfit.hotelmanage.service.ReservationService;
import edu.wfit.hotelmanage.mapper.ReservationMapper;
import org.springframework.stereotype.Service;

/**
* @author yuo
* @description 针对表【t_reservation】的数据库操作Service实现
* @createDate 2022-12-19 23:49:19
*/
@Service
public class ReservationServiceImpl extends ServiceImpl<ReservationMapper, Reservation>
    implements ReservationService{

}




