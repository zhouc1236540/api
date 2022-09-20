package com.gl.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gl.dao.UserMapper;
import com.gl.domain.PageArgs;
import com.gl.domain.SaleOrder;
import com.gl.domain.TO.Condition;
import com.gl.domain.Users;
import com.gl.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/7/5 9:34
 * @version: 1.0
 * Description: 接口实现
 */
@Service
public class UserserviceImpl implements UserService {
    @Autowired
    UserMapper userMapper;



    @Override
    public PageInfo<SaleOrder> getsaleOrder(Integer pageNum, Integer pageSize, PageArgs saleOrder) {
        PageHelper.startPage(pageNum,pageSize);
        List<SaleOrder> list = userMapper.getsaleOrder(saleOrder);
        PageInfo<SaleOrder> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }



    @Override
    public PageInfo<HashMap<String,Object>> getTable(Integer pageNum, Integer pageSize, String field, String tableName, List<Condition> condition) {

        PageHelper.startPage(pageNum,pageSize);
        List<HashMap<String,Object>> list = userMapper.getTable(field, tableName, condition);
        PageInfo<HashMap<String,Object>> pageInfo = new PageInfo<>(list);
        return  pageInfo;


    }

    @Override
    public Integer addtion(String tableName, List<String> field, List<String> value) {


        return  userMapper.addtionTable(tableName, field, value);
    }

    /**
     * 删除
     *
     * @param tableName
     * @param primaryKey
     * @param value
     * @return
     */
    @Override
    public Integer deleteTable(String tableName, String primaryKey, List value) {
        return userMapper.deleteTable(tableName,primaryKey,value);
    }

    @Override
    public List<Object> getUser(String field, String tableName, List<Object> condition) {
        return userMapper.getUser(field, tableName, condition);
    }

    /**
     * @return
     */
    @Override
    public Object getTableTest(String tableName) {
        return userMapper.getTableTest(tableName);
    }

    /**
     * saveOrUpdate
     *
     * @param fields
     * @param tableName
     * @param values
     * @param primaryKey
     * @param keyValue
     * @param primaryValue
     * @return
     */
    @Override
    public Integer saveOrUpdate(String fields, String tableName, String values, String primaryKey, String keyValue, String primaryValue) {
        return userMapper.saveOrUpdate(fields, tableName, values, primaryKey, keyValue, primaryValue);
    }

    /**
     * 更新
     *
     * @param tableName
     * @param fields
     * @param primary
     * @return
     */
    @Override
    public Integer update(String tableName, String fields, String primary) {
        return userMapper.update(tableName, fields, primary);
    }

    @Override
    public List<Map<String, Object>> getTable(String fields, String tableName, String condition, String groupBy, String orderBy) {
        return userMapper.getTable(fields, tableName, condition, groupBy, orderBy);
    }

    @Override
    public List<Object> privilegeTable(String id) {
        return userMapper.privilegeTable(id);
    }


    @Override
    public Users login(Users user) {
        return userMapper.login(user);
    }


}
