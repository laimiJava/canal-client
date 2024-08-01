package top.javatool.canal.example.syncPush;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import top.javatool.canal.example.entity.EmployeeDO;

import javax.annotation.Resource;

@Service
@Slf4j
public class SyncPush {
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishSearchEvent(EmployeeDO employeeDo) {
        //发布导出事件
        applicationEventPublisher.publishEvent(new SyncEvent(this, employeeDo));
    }
}
