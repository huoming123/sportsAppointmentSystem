package com.design.sportsAppointment.mapper;

import com.design.sportsAppointment.pojo.Appointment;
import java.util.List;
import com.design.sportsAppointment.dto.Page;
import org.apache.ibatis.annotations.Param;
/**
 * (Appointment)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-31 17:57:47
 */
public interface AppointmentMapper {
 
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Appointment queryById(Integer id);
    
        /**
     * 分页查询数据
     *
     * @param 
     * @return 实例对象
     */
    List<Appointment> getPageListByCondition(@Param("page") Page<Appointment> page);
    /**
     * 分页查询数据 查询总条数
     *
     * @param 
     * @return 实例对象
     */
    Integer getPageListCount(@Param("page") Page<Appointment> page);


    /**
     * 新增数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int insert(Appointment appointment);




    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 影响行数
     */
    int update(Appointment appointment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Appointment getByUserAndDate(Appointment appointment);


    void cancel(Appointment appointment);

    List<Appointment> statisticsAnalyze(Appointment appointment);

    List<Appointment> getAppointmentTotalAnalyse(Appointment appointment);
}

