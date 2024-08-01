package top.javatool.canal.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.javatool.canal.example.entity.EmployeeDO;

/**
 * <p>
 * 员工信息表 Mapper 接口
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<EmployeeDO> {

}
