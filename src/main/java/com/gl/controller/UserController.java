package com.gl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.gl.domain.DynamicQuery;
import com.gl.domain.PageArgs;
import com.gl.domain.SaleOrder;
import com.gl.domain.TO.Condition;
import com.gl.domain.TO.QueryCondition;
import com.gl.domain.Users;
import com.gl.page.ErrorEnum;
import com.gl.page.ResponseInfo;
import com.gl.services.impl.UserserviceImpl;
import com.gl.util.common.TokenUtils;
import com.gl.util.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


/**
 * @author: 山毛榉
 * @date : 2022/6/20 17:06
 * @version: 1.0
 */
@Controller
@RestController
public class UserController {
    @Autowired
    private UserserviceImpl userservice;
    Logger log = LoggerFactory.getLogger(UserController.class);

    @CrossOrigin
    @PostMapping("/gl/saleOrder/")
    public String getsaleOrder(@RequestBody PageArgs pageArgs, SaleOrder saleOrder, HttpServletRequest request) {
        // log.info("ksmc="+ksmc);
        System.out.println("------------------------------------------------" + pageArgs + "-----------------");

        String tokens = request.getHeader("Token");
        log.info(tokens);


        ResponseInfo saleOrderInfo = new ResponseInfo();
        try {


            saleOrderInfo.setCode(200);
            saleOrderInfo.setSuccess(true);
            saleOrderInfo.setMessages("获取成功");

            //pageNum 每页显示多少条,pageSize显示第几页
            PageInfo<SaleOrder> saleOrderPageInfo = userservice.getsaleOrder(pageArgs.getPageNum(), pageArgs.getPageSize(), pageArgs);
            saleOrderInfo.setData(saleOrderPageInfo);
            return JSON.toJSONString(saleOrderInfo);

        } catch (Exception e) {
            e.printStackTrace();
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            e.printStackTrace(writer);
            StringBuffer buffer = stringWriter.getBuffer();
            saleOrderInfo.setCode(500);
            saleOrderInfo.setSuccess(false);
            saleOrderInfo.setMessages("查询失败");
            //查询失败的异常信息封装返回到前台
            saleOrderInfo.setError_info(buffer.toString());
            saleOrderInfo.setData(null);

            return JSON.toJSONString(saleOrderInfo);

        }


    }

    /**
     * 获取token
     *
     * @param user
     * @return
     */
    @PostMapping("/gl/api/token/")
    public String getToken(@RequestBody Users user) {


        ResponseInfo responseInfo;
        try {
          //  Users info = userservice.login(user);
            //log.info(info.toString());
            String token = TokenUtils.token(user.getId(), user.getPs());
            responseInfo = new ResponseInfo();
            responseInfo.setCode(200);
            responseInfo.setMessages("获取录成功");
            responseInfo.setSuccess(true);
            responseInfo.setToken(token);
            responseInfo.setError_info("no");


        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter writer = new PrintWriter(stringWriter);
            e.printStackTrace(writer);
            StringBuffer buffer = stringWriter.getBuffer();

            responseInfo = new ResponseInfo();
            responseInfo.setCode(500);
            responseInfo.setMessages("失败用户名或者密码错误");
            responseInfo.setSuccess(false);
            responseInfo.setToken("获取失败");
            responseInfo.setError_info(buffer.toString());
            return JSON.toJSONString(responseInfo);
        }
        return JSON.toJSONString(responseInfo);

    }

    //sqlserver版本
    @PostMapping("gl/dynamic/query")
    public String getTable(@RequestParam("field")List field) {

        DynamicQuery query=new DynamicQuery();
        query.setField("ddzt,djhm");
        query.setTableName("xqzdh");
        query.setCondition("khmc='深圳甘露展厅'");
     /*   List<Map<String, Object>> info = userservice.getTable(query.getField(), query.getTableName(), query.getCondition());
        System.out.println("--------------------------------"+info);
        return  JSON.toJSONString(info);*/
        return  null;

    }
    //mysql版本
    @PostMapping("/gl/pageinfoObject")
    public String pageInfo() {


        Condition condition = new Condition();
        condition.setCloum("users_name");
        condition.setVal("'lisi'");


        ArrayList<Condition> objects = new ArrayList<>();
        objects.add(condition);


        Integer pageNum=1;
        Integer pageSize=2;
        PageInfo<HashMap<String,Object>> info = userservice.getTable(pageNum,pageSize,"helloworld","tb_user", objects);

        System.out.println("--------------------------------"+info);
        return  JSON.toJSONString(info);






    }

    @RequestMapping("/query")
    public Object query(){

         throw new BusinessException(ErrorEnum.NO_PREMISSION.getErrorCode(),ErrorEnum.NO_PREMISSION.getErrorMsg());

    }
    @GetMapping("/gl/delete/data")
    public  String deleteTabel(){
        //前端传过来的表名
        String tableName="tb_user";
        //前端传过来的主键列名
        String  primaryKey="user_id";
        //模拟前端传过来的id;
        String args="2,3";
        List<String> value=new ArrayList<String>();
        //已逗号分割传过来的string 放到数组
        String[] strs = args.split(",");
        //循环将分割后的值放到list并且,给每个加上单引号
        for (String  values:strs
             ) {
            value.add("'"+values+"'");

        }

        Integer integer = userservice.deleteTable(tableName,primaryKey,value);
        System.out.println("删除条数"+integer);


        return  null;

    }
    @PostMapping("/gl/addtion")
    public String  addtionTable(){
      /*   新增单据字符串和非字符串有没有要区分的可能 */

    String tableName="demo_test1";
    List<String> field= Arrays.asList("id","name","password","score");
    String fields=("7,张飞,123,90");
        ArrayList<String> value = new ArrayList<>();

        String[] args = fields.split(",");
        for (String  str: args
             ) {
            value.add("'"+str+"'");

        }

        Integer addtion = userservice.addtion(tableName, field, value);
        System.out.println(addtion+"-----");
        System.out.println("hello world2");


        return null;




    }

    @RequestMapping("/getTable")
    public String getTable(){
        /* select ${field} from ${tableName} where ${field} ${eq} ${value}
        group by ${field} order by ${field}
         *
         */
        System.out.println("--------------helloworld------------");
        String field="id,name,password,score";//前端传过来的要查询的列,
        String tableName="demo_test1";//前端传过来要查询的表名
        QueryCondition conditionTemp= new QueryCondition("id","=","4","");//条件封装到对象
        QueryCondition conditionTemp1= new QueryCondition("name","like","'lisi'","and");
        ArrayList<Object> condition = new ArrayList<>();
        condition.add(conditionTemp);
        condition.add(conditionTemp1);

        List<Object> user = userservice.getUser(field,tableName,condition);
        log.info(user.toString());

        return  user.toString();


    }

    @GetMapping("/gl/table")
    public String getTableTest(){

        Object tableTest = userservice.getTableTest("tb_user");


        return  null;


    }
    @PostMapping("gl/select")
    public String select(@RequestBody Map<String,String> map) {
        String fields = null;
        String tableName = null;
        String condition = null;
        String groupBy = null;
        String orderBy = null;

        if (map.containsKey("fields")) {

            fields =  map.get("fields");
        }
        if (map.containsKey("tableName")) {
            tableName = map.get("tableName");

        }
        if (map.containsKey("condition")) {
            condition = map.get("condition");


        }
        if (map.containsKey("groupBy")) {

            groupBy =  map.get("groupBy");
        }
        if (map.containsKey("orderBy")) {

            orderBy =  map.get("orderBy");

        }

        List<Map<String, Object>> table = userservice.getTable(fields, tableName, condition, groupBy, orderBy);


        for (Object o : table
        ) {
            System.out.println(o);

        }
        System.out.println();


        return JSON.toJSONString(table);


    }

    @RequestMapping("gl/update")
    /*
     * 先新增,新增失败再调用更新的方法
     */
    public String updates() {
        String tableName = "demo_test1";
        String fields = "name='王蒙'";
        String primaryKey = "id='7'";

        try {
            Integer update = userservice.update(tableName, fields, primaryKey);
        } catch (Exception e) {

            throw new RuntimeException("更新失败");
            //更新失败调用插入方法:


        }


        return null;

    }
    @RequestMapping("gl/saveOrUpdate")
    /* 先 */
    public String saveOrUpdate (@RequestBody Map<String,String> map,HttpServletRequest request) {
        String  fields =null;
        String tableName = null;
        String values = null;
        String username;
      /*  String token = request.getHeader("token");
        if (token!=null){
             username = TokenUtils.decodeToken(token);
        }
      else {
          return  JSON.toJSONString("code:500  msg:token 不能为空");

        }*/
        if(map.containsValue("drop")){
            return  JSON.toJSONString("code:500 msg:非法字符");

        }

        if (map.containsKey("fields")){
            fields = map.get("fields");

        }if (map.containsKey("tableName")){
            tableName=map.get("tableName");
            //在这做表的校验如果表存在于集合中则有权限,

          List<Object> privilege = getPrivilege("1");
            //去掉左右空格并且将传过来的sql语句字段转为小写
            if (privilege.contains(tableName.toLowerCase().trim())){

                System.out.println("-------------包含--------------");

            }
            else {
                System.out.println("-------------没有包含--------------");

               return  JSON.toJSONString("code:500 msg:权限不足");

            }



        }if (map.containsKey("values")){
            values=map.get("values");

        }

        //拿到fields列获取主键列名称
        assert fields != null;
        String[] splitKey = fields.split(",");
        System.out.println("分隔符--------------"+ Arrays.toString(splitKey) +"--------------分隔符");
        String primaryKey = splitKey[0];
        //拿到fields 列对应的values 并且获取第一个只也就是主键
        assert values != null;
        String[] splitValue = values.split(",");
        System.out.println("分隔符--------------"+ Arrays.toString(splitValue) +"--------------分隔符");
        String primaryValue = splitValue[0];
        //将新增的key和value 拼接成更新,
        StringBuilder keyValue = new StringBuilder();
        for (int i = 0; i < splitKey.length; i++) {
            for (int j = 0; j < splitValue.length; j++) {
                if (i == j) {

                    keyValue.append(splitKey[i]).append("=").append(splitValue[j]).append(",");

                }

            }

        }
        keyValue.deleteCharAt(keyValue.length() - 1);
        System.out.println("分隔符--------------"+keyValue+"--------------分隔符");

        Integer integer = userservice.saveOrUpdate(fields, tableName, values, primaryKey, keyValue.toString(), primaryValue);
        return null;


    }
    @PostMapping("gl/admin/link" )
    @ResponseBody

    @SuppressWarnings("unchecked")
    /*  读取数据库properties配置文件并且返回json数据到前端 */
    public String  modify(Model model,HttpServletRequest request) throws IOException {
        String token = request.getHeader("token");
        String username = TokenUtils.decodeToken(token);
        System.out.println("------"+token+"-------------------"+username+"---------");

        Properties config = new Properties();
        String path = System.getProperty("user.dir");
        FileInputStream fileInputStream = new FileInputStream(path + "/src/main/resources/jdbc.properties");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        config.load(bufferedInputStream);
        Map<String, String> map = new HashMap<String, String>((Map) config);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Object o:entries
        ) {
            Map.Entry entry = (Map.Entry) o;


        }
        model.addAttribute("map",map);

        return    JSON.toJSONString(map);



    }

    public  List<Object> getPrivilege(String username){
        //userNo为token解析的id
        List<Object> objects = userservice.privilegeTable(username);

        return  objects;
    }





}
