package edu.wfit.hotelmanage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_income
 */
@TableName(value ="t_income")
@Data
public class Income implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer cashierId;

    /**
     * 
     */
    private String cashierItem;

    /**
     * 
     */
    private Integer cashierPrice;

    /**
     * 
     */
    private Date cashierDate;

    /**
     * 
     */
    private Integer cashierType;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}