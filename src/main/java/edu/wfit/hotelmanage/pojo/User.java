package edu.wfit.hotelmanage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String userPassword;

    /**
     * 
     */
    private String trueName;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private String contact;

    /**
     * 
     */
    private Integer userType;

    /**
     * 
     */
    private String idCard;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}