package top.javatool.canal.example.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.javatool.canal.example.entity.EmployeeDO;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.entity.TUserDO;
import top.javatool.canal.example.mapper.SyncMapper;
import top.javatool.canal.example.mapper.TUserMapper;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 同步表 服务实现类
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Service
public class SyncServiceImpl extends ServiceImpl<SyncMapper, SyncDO> implements SyncService {
    @Resource
    private SyncMapper syncMapper;
    @Resource
    private TUserMapper tUserMapper;
    @Override
    public SyncDO getSyncDO() {
        return syncMapper.selectOne(Wrappers.<SyncDO>lambdaQuery()
                .eq(SyncDO::getIsEnable, 1)
                .last("limit 1"));
    }

    @Override
    public void selectIds(EmployeeDO employeeDO ) {
        List<TUserDO> tUserDOS = tUserMapper.selectList(Wrappers.<TUserDO>lambdaQuery()
                .eq(TUserDO::getEmployeeId, employeeDO.getId()));
        List<Long> ids = tUserDOS.stream().map(TUserDO::getId).collect(Collectors.toList());
        tUserMapper.update(null, Wrappers.<TUserDO>lambdaUpdate()
                .in(TUserDO::getId, ids)
                .set(TUserDO::getEmployeeName, employeeDO.getUserName()));
    }
}
