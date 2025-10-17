package com.design.sportsAppointment.service;

import com.design.sportsAppointment.pojo.SportsEquipment;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import com.design.sportsAppointment.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (SportsEquipment)表服务接口
 *
 * @author makejava
 * @since 2022-12-31 17:58:55
 */
public interface SportsEquipmentService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<SportsEquipment> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<SportsEquipment> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param sportsEquipment 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(SportsEquipment sportsEquipment);

    /**
     * 修改数据
     *
     * @param sportsEquipment 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(SportsEquipment sportsEquipment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

}
