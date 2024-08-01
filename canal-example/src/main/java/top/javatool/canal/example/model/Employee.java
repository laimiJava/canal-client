package top.javatool.canal.example.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 测试实体类
 */
@Data
@Table(name = "employee")
public class Employee implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;


    /**
     * 手机
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 编号
     */
    @Column(name = "no")
    private String no;



}