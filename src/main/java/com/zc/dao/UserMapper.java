package com.zc.dao;

import com.zc.domain.SaleOrder;
import com.zc.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/7/5 9:24
 * @version: 1.0
 * Description: mapper
 */
@Mapper
public interface UserMapper {

    List<Users> getU(Users user);
    List<Users> getListUser(Users user);
    List<SaleOrder> getsaleOrder(SaleOrder saleOrder);

}
