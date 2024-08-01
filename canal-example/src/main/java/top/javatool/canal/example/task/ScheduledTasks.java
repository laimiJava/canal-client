package top.javatool.canal.example.task;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.rocketmqListen.RmqProvdier;
import top.javatool.canal.example.service.EmployeeService;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;

@Component
public class ScheduledTasks extends RmqProvdier {

    @Resource
    private SyncService syncService;
    @Resource
    private EmployeeService employeeService;

//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;

//    @Scheduled(cron = "0/1 * * * * ?")
//    public void syncData() {
//        SyncDO syncDO = syncService.getSyncDO();
//        System.out.println("1");
//        if (syncDO != null) {
//            syncDO.setIsEnable(0);
//            syncService.updateById(syncDO);
//            this.send(JSONObject.toJSONString(syncDO));
////            rocketMQTemplate.convertAndSend("test001", JSONObject.toJSONString(syncDO));
////            syncService.removeById(syncDO.getId());
////            employeeService.getById(syncDO.getRedundantSourceId());
//        }
//    }

}
