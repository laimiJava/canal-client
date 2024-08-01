package top.javatool.canal.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.javatool.canal.example.entity.SyncDO;


/**
 * <p>
 * 同步表 Mapper 接口
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Mapper
public interface SyncMapper extends BaseMapper<SyncDO> {

}
