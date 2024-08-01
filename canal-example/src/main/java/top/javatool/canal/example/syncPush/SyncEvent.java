package top.javatool.canal.example.syncPush;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import top.javatool.canal.example.entity.EmployeeDO;

@Getter
public class SyncEvent extends ApplicationEvent {

    private static final long serialVersionUID = 5885956821347953071L;

    private final EmployeeDO employeeDo;

    public SyncEvent(Object source, EmployeeDO employeeDo) {
        super(source);
        this.employeeDo = employeeDo;
    }

}
