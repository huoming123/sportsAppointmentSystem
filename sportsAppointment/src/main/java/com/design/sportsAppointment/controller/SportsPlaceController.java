package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.SportsPlace;
import com.design.sportsAppointment.service.SportsPlaceService;
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
 * (SportsPlace)表控制层
 *
 * @author makejava
 * @since 2022-12-31 17:59:12
 */
@RestController
@RequestMapping("/sportsPlace")
public class SportsPlaceController {
    /**
     * 服务对象
     */
    @Autowired
    private SportsPlaceService sportsPlaceService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<SportsPlace>page) throws Exception{
        return this.sportsPlaceService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<SportsPlace> queryById(@RequestBody SportsPlace sportsPlace) {
        return this.sportsPlaceService.queryById(sportsPlace.getId());
    }

    /**
     * 新增数据
     *
     * @param sportsPlace 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody SportsPlace sportsPlace) {
        return this.sportsPlaceService.insert(sportsPlace);
    }

    /**
     * 编辑数据
     *
     * @param sportsPlace 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody SportsPlace sportsPlace) {
        return this.sportsPlaceService.update(sportsPlace);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody SportsPlace sportsPlace) {
        return this.sportsPlaceService.deleteById(sportsPlace.getId());
    }

}

