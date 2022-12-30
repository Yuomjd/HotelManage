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
 * @TableName t_reply
 */
@TableName(value ="t_reply")
@Data
public class Reply implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer replyId;

    /**
     * 
     */
    private Integer eId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private String replyContent;

    /**
     * 
     */
    private Date replyDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}