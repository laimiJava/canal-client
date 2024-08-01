package top.javatool.canal.example.rocketmqListen;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RmqProvdier{
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public boolean send(String message) {
        try {
            // 发送消息
            rocketMQTemplate.convertAndSend("test003", message);
            System.out.println("发送成功了");
        } catch (Exception e) {
            log.error("send message:{}", message, e);
            return false;
        }
        return true;
    }
}