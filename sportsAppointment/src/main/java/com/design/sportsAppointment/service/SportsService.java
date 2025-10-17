package com.design.sportsAppointment.service;

import com.design.sportsAppointment.pojo.Sports;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import com.design.sportsAppointment.dto.Page;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/**
 * (Sports)表服务接口
 *
 * @author makejava
 * @since 2022-12-31 17:58:35
 */
public interface SportsService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Sports> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Sports> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param sports 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Sports sports);

    /**
     * 修改数据
     *
     * @param sports 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Sports sports);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<List<Sports>> getSportsList();
}
