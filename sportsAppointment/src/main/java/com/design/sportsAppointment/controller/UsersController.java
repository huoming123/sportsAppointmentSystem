package com.design.sportsAppointment.controller;

import com.design.sportsAppointment.pojo.Users;
import com.design.sportsAppointment.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.design.sportsAppointment.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2022-12-31 17:59:41
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    
     /**
     * 分页查询
     *
     * @param //前端传来的参数
     * @return 单条数据
     */
   @PostMapping("/get/page/list")
    public RestFulBean<Map> getList(@RequestBody Page<Users>page) throws Exception{
        return this.usersService.getList(page);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
   @PostMapping("/get/by/id")
    public RestFulBean<Users> queryById(@RequestBody Users users) {
        return this.usersService.queryById(users.getId());
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) {
        return this.usersService.insert(users);
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public RestFulBean<String> edit(@RequestBody Users users) {
        return this.usersService.update(users);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
   @PostMapping("/delete")
    public RestFulBean<String> deleteById(@RequestBody Users users) {
        return this.usersService.deleteById(users.getId());
    }
    /**
     * 登录接口
     *
     * @param users 实体
     * @return 登录接口
     */
    @PostMapping("/login")
    public RestFulBean<Map> login(@RequestBody  Users users) {
        return this.usersService.login(users);
    }

    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception {
        return usersService.upload(coverFile);
    }
}

