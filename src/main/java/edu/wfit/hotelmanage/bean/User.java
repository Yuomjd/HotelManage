package edu.wfit.hotelmanage.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("t_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Integer userId;

    @TableField("user_name")
    private String userName;

    @TableField("user_password")
    private String userPassword;


}
