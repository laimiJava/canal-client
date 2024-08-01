package top.javatool.canal.example.handler;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.mapper.SyncMapper;
import top.javatool.canal.example.model.Employee;
import top.javatool.canal.example.rocketmqListen.RmqProvdier;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;


@Component
@CanalTable(value = "employee")
public class EmployeeHandler extends RmqProvdier implements EntryHandler<Employee> {

    @Resource
    private SyncMapper syncMapper;
    @Resource
    private SyncService syncService;
    private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);


    @Override
    public void insert(Employee employee) {
        logger.info("insert message  {}", employee);
    }

    @Override
    public void update(Employee before, Employee after) {
        logger.info("update before {} ", before);
        logger.info("update after {}", after);
        SyncDO syncDO = new SyncDO();
        syncDO.setRedundantSourceId(after.getId());
        syncDO.setPriority(1);
        syncDO.setName("t_user表");
        syncDO.setTableName("t_user");
        syncDO.setDatabaseName("test1");
        syncDO.setSetParams("1");
        syncDO.setSearchParams("2");
        this.send(JSONObject.toJSONString(syncDO));
//            rocketMQTemplate.convertAndSend("test001", JSONObject.toJSONString(syncDO));
//            syncService.removeById(syncDO.getId());
//            employeeService.getById(syncDO.getRedundantSourceId());
    }


    @Override
    public void delete(Employee employee) {
        logger.info("delete  {}", employee);
    }
}
