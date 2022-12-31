package edu.wfit.hotelmanage.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_room
 */
@TableName(value ="t_room")
@Data
public class Room implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer roomId;

    /**
     * 
     */
    private String roomType;

    /**
     * 
     */
    @TableField(value = "room_number")
    private String roomNumber;

    /**
     * 
     */
    private Integer beds;

    /**
     * 
     */
    private Integer roomPrice;

    /**
     * 
     */
    private String roomStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}