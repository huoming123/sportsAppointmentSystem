package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.Appointment;
import com.design.sportsAppointment.pojo.Rent;
import com.design.sportsAppointment.service.RentService;
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
 * (Rent)表控制层
 *
 * @author makejava
 * @since 2023-01-01 18:58:29
 */
@RestController
@RequestMapping("/rent")
public class RentController {
    /**
     * 服务对象
     */
    @Autowired
    private RentService rentService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Rent>page) throws Exception{
        return this.rentService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Rent> queryById(@RequestBody Rent rent) {
        return this.rentService.queryById(rent.getId());
    }

    /**
     * 新增数据
     *
     * @param rent 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Rent rent) {
        return this.rentService.insert(rent);
    }

    /**
     * 编辑数据
     *
     * @param rent 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Rent rent) {
        return this.rentService.update(rent);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Rent rent) {
        return this.rentService.deleteById(rent.getId());
    }
    /**
     * 取消租借
     *
     * @param rent 实体
     * @return
     */
    @PostMapping("/cancel")
    public RestFulBean<String> cancel(@RequestBody Rent rent) {
        return this.rentService.cancel(rent);
    }

    /**
     * 器材租借统计数据分析
     *
     * @param
     * @return
     */
    @PostMapping("/get/rent/total")
    public RestFulBean<Map> getRentTotalAnalyse(@RequestBody Rent rent) throws Exception {
        return rentService.getRentTotalAnalyse(rent);
    }
}

