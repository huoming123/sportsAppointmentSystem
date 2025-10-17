package com.design.sportsAppointment.mapper;

import com.design.sportsAppointment.pojo.Rent;
import java.util.List;
import com.design.sportsAppointment.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Rent)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-01 18:58:29
 */
public interface RentMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rent queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Rent> getPageListByCondition(@Param("page") Page<Rent> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Rent> page);


    /**
     * 新增数据
     *
     * @param rent 实例对象
     * @return 影响行数
     */
    int insert(Rent rent);




    /**
     * 修改数据
     *
     * @param rent 实例对象
     * @return 影响行数
     */
    int update(Rent rent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void cancel(Rent rent);


    List<Rent> getRentTotalAnalyse(Rent rent);
}

