package top.javatool.canal.example.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.javatool.canal.example.entity.EmployeeDO;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.mapper.EmployeeMapper;
import top.javatool.canal.example.mapper.TUserMapper;
import top.javatool.canal.example.service.EmployeeService;
import top.javatool.canal.example.syncPush.SyncPush;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Service
public class EmployeeServiceImpl extends SyncPush implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;
    @Resource
    private TUserMapper tUserMapper;
    @Override
    public void getById(Long id) {
        EmployeeDO employeeDO = employeeMapper.selectById(id);
        if (Objects.nonNull(employeeDO)) {
            this.publishSearchEvent(employeeDO);
        }
    }
}
