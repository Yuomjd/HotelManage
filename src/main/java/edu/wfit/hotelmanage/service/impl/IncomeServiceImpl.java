package edu.wfit.hotelmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import edu.wfit.hotelmanage.pojo.Income;
import edu.wfit.hotelmanage.service.IncomeService;
import edu.wfit.hotelmanage.mapper.IncomeMapper;
import org.springframework.stereotype.Service;

/**
* @author yuo
* @description 针对表【t_income】的数据库操作Service实现
* @createDate 2022-12-19 23:49:22
*/
@Service
public class IncomeServiceImpl extends ServiceImpl<IncomeMapper, Income>
    implements IncomeService{

}




