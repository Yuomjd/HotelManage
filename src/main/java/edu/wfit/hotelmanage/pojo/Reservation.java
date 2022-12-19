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
 * @TableName t_reservation
 */
@TableName(value ="t_reservation")
@Data
public class Reservation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer bookId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer roomId;

    /**
     * 
     */
    private Date bookDate;

    /**
     * 
     */
    private Date checkInDate;

    /**
     * 
     */
    private Date checkOutDate;

    /**
     * 
     */
    private String bookStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}