package com.design.sportsAppointment.service.impl;

import com.design.sportsAppointment.mapper.SportsEquipmentMapper;
import com.design.sportsAppointment.pojo.Rent;
import com.design.sportsAppointment.mapper.RentMapper;
import com.design.sportsAppointment.pojo.SportsEquipment;
import com.design.sportsAppointment.service.RentService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.sportsAppointment.pojo.res.RestFulBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.sportsAppointment.util.PageUtil;
import com.design.sportsAppointment.dto.Page;
/**
 * (Rent)表服务实现类
 *
 * @author makejava
 * @since 2023-01-01 18:58:29
 */
@Service("rentService")
public class RentServiceImpl implements RentService {
    @Autowired
    private RentMapper rentMapper;
    @Autowired
    private SportsEquipmentMapper sportsEquipmentMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Rent> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Rent> list= rentMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Rent rent: list){
                if(rent.getStatus()==1){ //状态等于1的话 说明已经结账了 所以租借订单不能编辑了
                    rent.setOrderStatus("订单已完成");
                    rent.setDisabled(true);
                }
                if(rent.getStatus()==-1){ //状态等于-1的话 说明取消了 所以租借订单不能编辑了
                    rent.setOrderStatus("订单已取消");
                    rent.setDisabled(true);
                }
                if(rent.getStatus()==0){ //状态等于0的话 说明租借订单正常 可以编辑
                    rent.setOrderStatus("正常");
                    rent.setDisabled(false);
                }
                if(rent.getGoBack()==1){ //状态等于1的话 说明已经归还了 所以租借订单不能编辑了

                    rent.setBackDisabled(true);
                }
                if(rent.getStatus()!=1){ //状态不等于 1 说明可以编辑
                    rent.setBackDisabled(false);
                }
            }
        }
        //根据条件查询数据的条数
        Integer count = rentMapper.getPageListCount(page);
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
    public RestFulBean<Rent> queryById(Integer id) {
       Rent rent=this.rentMapper.queryById(id);
         return RestFulBean.succ(rent);
    }

    /**
     * 器材租借
     *
     * @param rent 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Rent rent) {
        SportsEquipment sportsEquipment =sportsEquipmentMapper.getByName(rent.getName()); //根据器材名称查找到对应器材的价钱
        if(rent.getNum()==null){
            return RestFulBean.error("数量不能为空");
        }
        if(rent.getNum()>sportsEquipment.getTotal()){
            return RestFulBean.error("租借数量不能大于库存");
        }
        rent.setFee(rent.getNum()*sportsEquipment.getPrices()); //计算费用
        this.rentMapper.insert(rent);//执行数据库的新增语句
        sportsEquipment.setTotal(sportsEquipment.getTotal()-rent.getNum()); //库存-租借的数量
        sportsEquipmentMapper.update(sportsEquipment);//刷新库存
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param rent 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Rent rent) {
        if(rent.getGoBack()==1){ //归还刷新库存
            SportsEquipment sportsEquipment =sportsEquipmentMapper.getByName(rent.getName()); //根据器材名称查找到对应器材的价钱
            sportsEquipment.setTotal(sportsEquipment.getTotal()+rent.getNum()); //归还时库存+租借的数量
            sportsEquipmentMapper.update(sportsEquipment);//刷新库存
        }
        this.rentMapper.update(rent);//执行数据库的修改语句 根据id 修改
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
        this.rentMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<String> cancel(Rent rent) {
        this.rentMapper.cancel(rent); //取消器材租借
        SportsEquipment sportsEquipment =sportsEquipmentMapper.getByName(rent.getName()); //根据器材名称查找到对应器材的价钱
        sportsEquipment.setTotal(sportsEquipment.getTotal()+rent.getNum()); //取消时库存+租借的数量
        sportsEquipmentMapper.update(sportsEquipment);//刷新库存
        return RestFulBean.succ("取消成功");
    }

    @Override
    public RestFulBean<Map> getRentTotalAnalyse(Rent rent) {
        if(rent.getMonth()!=null){ //月份如果点击搜索
            rent.setYearMonth(rent.getYear().toString()+'-'+rent.getMonth()); //处理一下日期 把它变成类型这样的 2023-02
        }
        List<Rent> list =rentMapper.getRentTotalAnalyse(rent);//器材租借统分析
        Map result = new HashMap(); //定义一个map 对象
        List typeList = new ArrayList<>(); //定义一个数组
        for(Rent rented:list){
            Map type =new HashMap();//定义一个map 对象
            type.put("value",rented.getSum()); //每个器材租借的费用
            type.put("name",rented.getName()); //器材
            typeList.add(type);
        }
        result.put("typeList",typeList);
        return RestFulBean.succ(result);
    }
}
