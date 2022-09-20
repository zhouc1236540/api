package com.gl.dao;

import com.gl.domain.PageArgs;
import com.gl.domain.SaleOrder;
import com.gl.domain.TO.Condition;
import com.gl.domain.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    Users login(Users user);

    List<SaleOrder> getsaleOrder(PageArgs saleOrder);

    //新增
    Integer addtionTable(@Param("tableName") String tableName,
                      @Param("field") List<String> field,
                      @Param("value") List<String> value);

    //删除 表名,主键,主键的值
    Integer deleteTable(@Param("tableName") String tableName,
                        @Param("primaryKey") String primaryKey,
                        @Param("value") List value
    );

    //更新
    Integer updateTable(@Param("tableName") String tableName,
                        @Param("colName") String colName,
                        @Param("colValue") String colValue,
                        @Param("id") String id,
                        @Param("item") String item
    );

    //查询
    List<HashMap<String, Object>> getTable(@Param("field") String field,
                                           @Param("tableName") String tableName,
                                           @Param("condition") List<Condition> condition);



    List<Object> getUser(@Param("field")String field,
                         @Param("tableName") String tableName,
                         @Param("condition") List<Object> condition);


    /**
     *  insert into  ${tableName} fields value ${value}
     *  update  ${tableName}  set ${field=value} where ${primaryKey=value}
     * @param tableName
     * @return
     */
    /*Integer saveOrUpdate(@Param("tableName") String tableName,
                         @Param("field") String field,
                         @Param("value") String  value

                         );*/

    Object getTableTest(@Param("tableName") String tableName);


    /**
     * saveOrUpdate
     * @param fields
     * @return
     * insert users  ${fields} value ${value}
     * update  users set  fields = fileValue where ${primaryKye} =${value}
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
