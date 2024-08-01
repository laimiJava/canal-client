package top.javatool.canal.example.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import top.javatool.canal.example.entity.SyncDO;
import top.javatool.canal.example.service.EmployeeService;
import top.javatool.canal.example.service.SyncService;

import javax.annotation.Resource;

/**
 * <p>
 * 同步表 前端控制器
 * </p>
 *
 * @author fbb
 * @since 2024-07-31
 */
@Controller
@RequestMapping("/factory/syncDO")
public class SyncController {


    @Resource
    private SyncService syncService;

    @Resource
    private EmployeeService employeeService;
    @GetMapping(value = "/sync")
    void sync() {
        //根据优先级排序
        SyncDO syncDO = syncService.getSyncDO();
        if (syncDO != null) {
            System.out.println(JSONObject.toJSONString(syncDO));
            employeeService.getById(syncDO.getRedundantSourceId());
        }
    }
}

