package com.design.sportsAppointment.mapper;

import com.design.sportsAppointment.pojo.SportsPlace;
import java.util.List;
import com.design.sportsAppointment.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (SportsPlace)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-31 17:59:12
 */
public interface SportsPlaceMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SportsPlace queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<SportsPlace> getPageListByCondition(@Param("page") Page<SportsPlace> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<SportsPlace> page);


    /**
     * 新增数据
     *
     * @param sportsPlace 实例对象
     * @return 影响行数
     */
    int insert(SportsPlace sportsPlace);




    /**
     * 修改数据
     *
     * @param sportsPlace 实例对象
     * @return 影响行数
     */
    int update(SportsPlace sportsPlace);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

