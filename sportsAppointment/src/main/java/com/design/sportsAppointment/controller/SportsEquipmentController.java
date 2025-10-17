package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.SportsEquipment;
import com.design.sportsAppointment.service.SportsEquipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.sportsAppointment.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (SportsEquipment)表控制层
 *
 * @author makejava
 * @since 2022-12-31 17:58:55
 */
@RestController
@RequestMapping("/sportsEquipment")
public class SportsEquipmentController {
    /**
     * 服务对象
     */
    @Autowired
    private SportsEquipmentService sportsEquipmentService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<SportsEquipment>page) throws Exception{
        return this.sportsEquipmentService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<SportsEquipment> queryById(@RequestBody SportsEquipment sportsEquipment) {
        return this.sportsEquipmentService.queryById(sportsEquipment.getId());
    }

    /**
     * 新增数据
     *
     * @param sportsEquipment 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody SportsEquipment sportsEquipment) {
        return this.sportsEquipmentService.insert(sportsEquipment);
    }

    /**
     * 编辑数据
     *
     * @param sportsEquipment 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody SportsEquipment sportsEquipment) {
        return this.sportsEquipmentService.update(sportsEquipment);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody SportsEquipment sportsEquipment) {
        return this.sportsEquipmentService.deleteById(sportsEquipment.getId());
    }

}

