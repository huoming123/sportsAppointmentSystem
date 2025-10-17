package com.design.sportsAppointment.service.impl;

import com.design.sportsAppointment.pojo.Sports;
import com.design.sportsAppointment.mapper.SportsMapper;
import com.design.sportsAppointment.service.SportsService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import com.design.sportsAppointment.pojo.res.RestFulBean;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import com.design.sportsAppointment.util.PageUtil;
import com.design.sportsAppointment.dto.Page;
/**
 * (Sports)表服务实现类
 *
 * @author makejava
 * @since 2022-12-31 17:58:35
 */
@Service("sportsService")
public class SportsServiceImpl implements SportsService {
    @Autowired
    private SportsMapper sportsMapper;
         /**
     * 分页查询数据
     *
     * @param //前端传来的参数
     * @return 实例对象
     */
    @Override
    public RestFulBean<Map> getList(Page<Sports> page) throws Exception{
        //mysql分页要先在外面计算好从第几条数据开始获取数据
        Integer pageNum =page.getPageNum();
        Integer startNum =(pageNum-1)* page.getPageSize();
        page.setStartNum(startNum);
        //根据前端传来的的条件进行查询  //分页查询
        List<Sports> list= sportsMapper.getPageListByCondition(page);
        if(list.size()>0){  //如果数据大于0 用for循环把照片的完整路劲返回前端显示
            for(Sports sports: list){
                sports.setImagesUrl("http://localhost:8087/file/"+sports.getImages());
            }
        }
        //根据条件查询数据的条数
        Integer count = sportsMapper.getPageListCount(page);
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
    public RestFulBean<Sports> queryById(Integer id) {
       Sports sports=this.sportsMapper.queryById(id);
         return RestFulBean.succ(sports);
    }

    /**
     * 新增数据
     *
     * @param sports 实例对象
     * @return 实例对象
     */
    @Override
    public RestFulBean<String> insert(Sports sports) {
        if(sports.getSportsName()==null){//对前端传过来的值进行判空处理，如果为空，就返回对应的报错信息
            return RestFulBean.error("场地名称不能为空");
        }
        if(sports.getAddress()==null){
            return RestFulBean.error("地址不能为空");
        }
        this.sportsMapper.insert(sports);//执行数据库的新增语句
        return RestFulBean.succ("添加成功");
    }

    /**
     * 修改数据
     *
     * @param sports 实例对象
     * @return 实例对象
     */
    @Override
     public RestFulBean<String> update(Sports sports) {
        this.sportsMapper.update(sports);//执行数据库的修改语句 根据id 修改
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
        this.sportsMapper.deleteById(id);//执行数据库的删除语句 根据id 删除
         return RestFulBean.succ("删除成功");
    }

    @Override
    public RestFulBean<List<Sports>> getSportsList() {
        List<Sports> list= sportsMapper.getSportsList();//获取体育馆下拉的数据
        return RestFulBean.succ(list);
    }
}
