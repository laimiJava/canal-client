package top.javatool.canal.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")

public class TUserDO implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    private String userName;


    private Integer gender;


    private Integer countryId;


    private Date birthday;

    private String employeeName;

    private Long employeeId;


    private Date createTime;


}
