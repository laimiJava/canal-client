package top.javatool.canal.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 员工信息表
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @TableName("employee")

public class EmployeeDO implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
      private Long id;


      private String userName;


      private String phone;


      private String no;


}
