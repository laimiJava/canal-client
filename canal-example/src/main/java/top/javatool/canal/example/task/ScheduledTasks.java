package top.javatool.canal.example.task;

import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.service.EmployeeService;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;
@Component
public class ScheduledTasks {

    @Resource
    private SyncService syncService;
    @Resource
    private EmployeeService employeeService;


    @Scheduled(cron = "0/1 * * * * ?")
    public void syncData() {
        SyncDO syncDO = syncService.getSyncDO();
        System.out.println("1");
        if (syncDO != null) {
            System.out.println(JSONObject.toJSONString(syncDO));
            syncService.removeById(syncDO.getId());
            employeeService.getById(syncDO.getRedundantSourceId());
        }
    }

}
