package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.Appointment;
import com.design.sportsAppointment.pojo.Rent;
import com.design.sportsAppointment.service.AppointmentService;
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
 * (Appointment)表控制层
 *
 * @author makejava
 * @since 2022-12-31 17:57:47
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    /**
     * 服务对象
     */
    @Autowired
    private AppointmentService appointmentService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Appointment>page) throws Exception{
        return this.appointmentService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Appointment> queryById(@RequestBody Appointment appointment) {
        return this.appointmentService.queryById(appointment.getId());
    }

    /**
     * 新增数据
     *
     * @param appointment 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Appointment appointment) {
        return this.appointmentService.insert(appointment);
    }

    /**
     * 编辑数据
     *
     * @param appointment 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Appointment appointment) {
        return this.appointmentService.update(appointment);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Appointment appointment) {
        return this.appointmentService.deleteById(appointment.getId());
    }
    /**
     * 取消预约
     *
     * @param appointment 实体
     * @return
     */
    @PostMapping("/cancel")
    public RestFulBean<String> cancel(@RequestBody Appointment appointment) {
        return this.appointmentService.cancel(appointment);
    }
    /**
     * 统计分析 每月营业额
     *
     * @param appointment 实体
     * @return
     */
    @PostMapping("/statistics/analyze")
    public RestFulBean<Map> statisticsAnalyze(@RequestBody Appointment appointment) {
        return this.appointmentService.statisticsAnalyze(appointment);
    }
    /**
     * 场地租借统计数据分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/appointment/total")
    public RestFulBean<Map> getAppointmentTotalAnalyse(@RequestBody Appointment appointment) throws Exception {
        return appointmentService.getAppointmentTotalAnalyse(appointment);
    }
}

