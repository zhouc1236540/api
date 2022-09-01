package com.zc.services;

import com.github.pagehelper.PageInfo;
import com.zc.domain.SaleOrder;
import com.zc.domain.Users;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/7/5 9:33
 * @version: 1.0
 * Description: 服务接口
 */
public interface UserService {

    List<Users> getU(Users user);

    PageInfo<Users> getListUsers(Integer pageNum, Integer pageSize, Users user);

    PageInfo<SaleOrder> getsaleOrder(Integer pageNum, Integer pageSize, SaleOrder saleOrder);
}
