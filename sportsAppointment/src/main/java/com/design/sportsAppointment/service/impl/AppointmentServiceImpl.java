package com.design.sportsAppointment.service.impl;

import com.design.sportsAppointment.pojo.Appointment;
import com.design.sportsAppointment.mapper.AppointmentMapper;
import com.design.sportsAppointment.pojo.Rent;
import com.design.sportsAppointment.service.AppointmentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.sportsAppointment.pojo.res.RestFulBean;

import java.util.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.design.sportsAppointment.util.PageUtil;
import com.design.sportsAppointment.dto.Page;
/**
 * (Appointment)表服务实现类
 *
 * @author makejava
 * @since 2022-12-31 17:57:47
 */
@Service("appointmentService")
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
         /**
     * 分页查询预约订单数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Appointment> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Appointment> list= appointmentMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Appointment appointment: list){
               if(appointment.getStatus()==1){ //状态等于1的话 说明已经结账了 所以预约订单不能编辑了
                   appointment.setOrderStatus("订单已完成");
                   appointment.setDisabled(true);
               }
                if(appointment.getStatus()==-1){ //状态等于-1的话 说明取消了 所以预约订单不能编辑了
                    appointment.setOrderStatus("订单已取消");
                    appointment.setDisabled(true);
                }
                if(appointment.getStatus()==0){ //状态等于0的话 说明订单正常 可以编辑
                    appointment.setOrderStatus("正常");
                    appointment.setDisabled(false);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = appointmentMapper.getPageListCount(page);
        //拿到总条数进行分页处理
        Map<Object, Object> map = PageUtil.pagingPrepare(page, count);
        //最后把查询到的数据用map返回前显示
        map.put("list",list);
        return RestFulBean.succ(map);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RestFulBean<Appointment> queryById(Integer id) {
       Appointment appointment=this.appointmentMapper.queryById(id);
         return RestFulBean.succ(appointment);
    }

    /**
     * 在线预约
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Appointment appointment) {
        //对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
        if(appointment.getTelephone()==null){
            return RestFulBean.error("手机号码不能为空");
        }

        if(appointment.getAppointmentTime()==null){
            return RestFulBean.error("预约时间不能为空");
        }
        if(appointment.getTimeQuantum()==null){
            return RestFulBean.error("时间段不能为空");
        }
        if(appointment.getTelephone().trim().length()!=11){
            return RestFulBean.error("请输入11位手机号码");
        }
        //手机号码只能是数字 用正则法则判断
        Pattern pattern = Pattern.compile("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        Matcher isNum = pattern.matcher(appointment.getTelephone().trim());
        if(!isNum.matches()){  //如果不等于true 则进去条件
            return RestFulBean.error("手机号码只能是数字"); //不是数字
        }
        //获取系统当前时间
        Date date = new Date();
        //将当前日期时间转为毫秒值
        long t1 = date.getTime();
        //前端传来的预约时间
        long t2 = appointment.getAppointmentTime().getTime();
        if(t2-t1<0){  //判断预约时间是否大于当前系统时间
            return RestFulBean.error("预约时间不能小于当前系统时间");
        }
        Appointment appointmented=this.appointmentMapper.getByUserAndDate(appointment); //根据场地跟时间判断场地是否已经预约了
        if(appointmented!=null){
            return RestFulBean.error("该时间段已经有人预约了该场地，请不要重复预约");
        }
        this.appointmentMapper.insert(appointment);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param appointment 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Appointment appointment) {
        this.appointmentMapper.update(appointment);//执行数据库的修改语句 根据id 修改
        return RestFulBean.succ("修改成功"); 
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public RestFulBean<String> deleteById(Integer id) {
        this.appointmentMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<String> cancel(Appointment appointment) {
        this.appointmentMapper.cancel(appointment);//取消预约
        return RestFulBean.succ("取消成功");
    }

    @Override
    public RestFulBean<Map> statisticsAnalyze(Appointment appointment) {
       List<Appointment>list=appointmentMapper.statisticsAnalyze(appointment);
       Map result = new HashMap();
         List<String> monthList =new ArrayList<>(); //定义月份数组
        List<Double> sumList =new ArrayList<>();//定义营业额数组
        for (Appointment appointmented :list){
            monthList.add(appointmented.getMonth()); //把月份加到数组种
            sumList.add(appointmented.getSum());//把营业额加到数组种
        }
        //最后加到对象中返回给前端
        result.put("monthList",monthList);
        result.put("sumList",sumList);
        return RestFulBean.succ(result);
    }

    @Override
    public RestFulBean<Map> getAppointmentTotalAnalyse(Appointment appointment) {
        List<String> placeList = new ArrayList<>();
        List<Double> sumList = new ArrayList<>();
        if(appointment.getMonth()!=null){ //月份如果点击搜索
            appointment.setYearMonth(appointment.getYear().toString()+'-'+appointment.getMonth()); //处理一下日期 把它变成类型这样的 2023-02
        }
        List<Appointment> list =appointmentMapper.getAppointmentTotalAnalyse(appointment);//场地租借统分析
        Map result = new HashMap(); //定义一个map 对象
        for(Appointment appointmented:list){
            placeList.add(appointmented.getSportsName()); //体育场地
            sumList.add(appointmented.getSum()); //租借总费用
        }
        result.put("placeList",placeList);
        result.put("sumList",sumList);
        return RestFulBean.succ(result);
    }
}
