package top.javatool.canal.example.rocketmqConsumer;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.service.EmployeeService;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;

@Component
@Slf4j
@RocketMQMessageListener(topic = "test003", consumerGroup = "ta-cipher-encode")
public class RocketMQConsumer implements RocketMQListener<String> {
    @Resource
    private SyncService syncService;
    @Resource
    private EmployeeService employeeService;

    @Override
    public void onMessage(String message) {
        try {
            log.info("message:{}", message);
//            SyncDO syncDO = (SyncDO) JSONObject.parse(message);
            ObjectMapper objectMapper = new ObjectMapper();
            SyncDO syncDO = objectMapper.readValue(message, SyncDO.class);
            employeeService.getById(syncDO.getRedundantSourceId());
            System.out.println(message+"消费成功啦！");
        } catch (Exception e) {
            log.error("errorMessage:{}", message);
            // 抛出异常会重新消费消息
            throw new RuntimeException("Message processing failed", e);
        }
    }
}