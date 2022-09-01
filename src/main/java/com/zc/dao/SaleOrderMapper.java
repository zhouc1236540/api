package com.zc.dao;

import com.zc.domain.SaleOrder;
import com.zc.domain.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: 山毛榉
 * @date : 2022/8/31 18:02
 * @version: 1.0
 */
@Mapper
public interface SaleOrderMapper {
    List<SaleOrder> getsaleOrder(SaleOrder saleOrder);
}
