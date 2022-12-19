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
 * @TableName t_evaluation
 */
@TableName(value ="t_evaluation")
@Data
public class Evaluation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer eId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer score;

    /**
     * 
     */
    private String eContent;

    /**
     * 
     */
    private Date eDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}