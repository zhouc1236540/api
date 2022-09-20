package com.gl.dao;

import com.gl.domain.SaleOrder;
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
