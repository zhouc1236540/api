package com.zc.services.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zc.dao.SaleOrderMapper;
import com.zc.dao.UserMapper;
import com.zc.domain.SaleOrder;
import com.zc.domain.Users;
import com.zc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     *
     * @param user
     * @return
     */
    @Override
    public List<Users> getU(Users user) {
        return userMapper.getU(user);
    }

    @Override
    public PageInfo<Users> getListUsers(Integer pageNum, Integer pageSize, Users user) {
        PageHelper.startPage(pageNum,pageSize);
        List<Users> list = userMapper.getListUser(user);
        PageInfo<Users> pageInfo = new PageInfo<>(list);
        return  pageInfo;

    }

    @Override
    public PageInfo<SaleOrder> getsaleOrder(Integer pageNum, Integer pageSize, SaleOrder saleOrder) {
        PageHelper.startPage(pageNum,pageSize);
        List<SaleOrder> list = userMapper.getsaleOrder(saleOrder);
        PageInfo<SaleOrder> pageInfo = new PageInfo<>(list);
        return  pageInfo;
    }
}
