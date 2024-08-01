package top.javatool.canal.example.listen;

import com.alibaba.fastjson.JSONObject;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import top.javatool.canal.example.entity.EmployeeDO;
import top.javatool.canal.example.service.SyncService;
import top.javatool.canal.example.syncPush.SyncEvent;

import javax.annotation.Resource;

/**
 * 监听器
 *
 * @author sjf
 * @since 2023/11/08
 **/
@Component
@Slf4j
//@Async
public class SyncListen implements ApplicationListener<SyncEvent> {

    @Resource
    private SyncService syncService;

    @Override
    public void onApplicationEvent(@NonNull SyncEvent event) {
        log.info("同步信息!  {}", JSONObject.toJSONString(event));
        log.info("发送消息内容：{}", JSONObject.toJSONString(event.getEmployeeDo()));
        EmployeeDO employeeDO = event.getEmployeeDo();
        syncService.selectIds(employeeDO);
    }
}
