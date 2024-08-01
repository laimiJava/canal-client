package top.javatool.canal.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 冗余数据更新目标表配置
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sync")
public class SyncDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    private Integer priority;


    private String name;


    private String tableName;


    private String databaseName;


    private Long redundantSourceId;


    private String setParams;


    private String searchParams;

    private Integer isEnable;


}
