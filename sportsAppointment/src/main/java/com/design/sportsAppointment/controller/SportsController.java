package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.Sports;
import com.design.sportsAppointment.service.SportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.sportsAppointment.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Sports)表控制层
 *
 * @author makejava
 * @since 2022-12-31 17:58:35
 */
@RestController
@RequestMapping("/sports")
public class SportsController {
    /**
     * 服务对象
     */
    @Autowired
    private SportsService sportsService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Sports>page) throws Exception{
        return this.sportsService.getList(page);
    }

    /**
     * 体育馆下拉
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
    @PostMapping("/get/sports/list")
    public RestFulBean<List<Sports>> getSportsList() throws Exception{
        return this.sportsService.getSportsList();
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Sports> queryById(@RequestBody Sports sports) {
        return this.sportsService.queryById(sports.getId());
    }

    /**
     * 新增数据
     *
     * @param sports 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Sports sports) {
        return this.sportsService.insert(sports);
    }

    /**
     * 编辑数据
     *
     * @param sports 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Sports sports) {
        return this.sportsService.update(sports);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Sports sports) {
        return this.sportsService.deleteById(sports.getId());
    }

}

