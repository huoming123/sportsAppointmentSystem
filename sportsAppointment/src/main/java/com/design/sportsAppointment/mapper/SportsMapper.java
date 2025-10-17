package com.design.sportsAppointment.mapper;

import com.design.sportsAppointment.pojo.Sports;
import java.util.List;
import com.design.sportsAppointment.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Sports)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-31 17:58:35
 */
public interface SportsMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Sports queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Sports> getPageListByCondition(@Param("page") Page<Sports> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Sports> page);


    /**
     * 新增数据
     *
     * @param sports 实例对象
     * @return 影响行数
     */
    int insert(Sports sports);




    /**
     * 修改数据
     *
     * @param sports 实例对象
     * @return 影响行数
     */
    int update(Sports sports);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Sports> getSportsList();
}

