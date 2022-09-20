package com.gl.services;

import com.github.pagehelper.PageInfo;
import com.gl.domain.PageArgs;
import com.gl.domain.SaleOrder;
import com.gl.domain.TO.Condition;

import com.gl.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by IntelliJ IDEA
 *
 * @author: 山毛榉
 * @date : 2022/7/5 9:33
 * @version: 1.0
 * Description: 服务接口
 */
public interface UserService {

    Users login(Users user);
    PageInfo<SaleOrder> getsaleOrder(Integer pageNum, Integer pageSize, PageArgs saleOrder);

    PageInfo<HashMap<String,Object>> getTable(Integer pageNum, Integer pageSize, String field,
                               String tableName,
                               List<Condition> condition);


    Integer addtion( String tableName,
                  List<String> field,
                 List<String> value);


    /**
     * 删除
     * @param tableName
     * @param primaryKey
     * @param value
     * @return
     */
    Integer deleteTable(@Param("tableName") String tableName,
                    @Param("primaryKey") String primaryKey,
                    @Param("value") List value
);
    List<Object> getUser(@Param("field")String field,
                         @Param("tableName") String tableName,
                         @Param("condition") List<Object> condition);

    /**
     *
     * @return
     */
   Object getTableTest(String tableName);


    /**
     * saveOrUpdate
     * @param fields
     * @return
     */
    Integer  saveOrUpdate(@Param("fields") String fields ,
                          @Param("tableName") String tableName,
                          @Param("values") String values,
                          @Param("primaryKey") String primaryKey,
                          @Param("keyValue") String  keyValue,
                          @Param("primaryValue") String primaryValue
    );

    /**
     * 更新
     * @param tableName
     * @param fields
     * @param primary
     * @return
     */
    Integer update(@Param("tableName")String tableName,
                   @Param("fields")String fields,
                   @Param("primaryKey") String primary
    );
    List<Map<String, Object>> getTable(@Param("fields") String fields,
                                       @Param("tableName") String tableName,
                                       @Param("condition") String condition,
                                       @Param("groupBy") String groupBy,
                                       @Param("orderBy") String orderBy);
    List<Object> privilegeTable(@Param("id") String id);
}
