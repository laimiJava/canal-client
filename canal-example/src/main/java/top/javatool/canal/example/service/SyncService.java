package top.javatool.canal.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.javatool.canal.example.entity.EmployeeDO;
import top.javatool.canal.example.entity.SyncDO;

import java.util.List;

/**
 * <p>
 * 同步表 服务类
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Service
public interface SyncService extends IService<SyncDO> {
    SyncDO getSyncDO();
    /**
     * 获取源数据
     *
     * @param
     */
    void selectIds(EmployeeDO employeeDO );
    /**
     * 获取源数据
     * @param
     */

}
