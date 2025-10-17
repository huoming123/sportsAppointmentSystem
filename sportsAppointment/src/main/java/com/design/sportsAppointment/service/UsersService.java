package com.design.sportsAppointment.service;

import com.design.sportsAppointment.pojo.Users;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import com.design.sportsAppointment.dto.Page;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-12-31 17:59:41
 */
public interface UsersService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Users> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Users> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Users users);

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Users users);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> login(Users users);

    RestFulBean<Map> upload(MultipartFile coverFile) throws Exception;
}
