package com.design.sportsAppointment.service;

import com.design.sportsAppointment.pojo.Rent;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import com.design.sportsAppointment.dto.Page;
import java.io.IOException;
import java.util.Map;
/**
 * (Rent)表服务接口
 *
 * @author makejava
 * @since 2023-01-01 18:58:29
 */
public interface RentService {
     
        /**
     * 分页查找数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
     RestFulBean<Map> getList(Page<Rent> page)throws Exception;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Rent> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param rent 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Rent rent);

    /**
     * 修改数据
     *
     * @param rent 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Rent rent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<String> cancel(Rent rent);


    RestFulBean<Map> getRentTotalAnalyse(Rent rent);
}
