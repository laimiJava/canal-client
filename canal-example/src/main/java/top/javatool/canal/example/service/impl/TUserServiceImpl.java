package top.javatool.canal.example.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.javatool.canal.example.entity.TUserDO;
import top.javatool.canal.example.mapper.TUserMapper;
import top.javatool.canal.example.service.TUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUserDO> implements TUserService {

}
