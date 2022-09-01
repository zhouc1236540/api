package com.zc.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.zc.domain.SaleOrder;
import com.zc.domain.TokenInfo;
import com.zc.domain.UserInfo;
import com.zc.domain.Users;
import com.zc.page.ResponseInfo;
import com.zc.services.impl.UserserviceImpl;

import com.zc.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;


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
    private Users user;


    @GetMapping("/userInfo/{pageNum}/{pageSize}/{user}")
    public String getUser(HttpServletResponse response, @PathVariable Integer pageNum, @PathVariable Integer pageSize, Users user) {
        response.addHeader("Access-Control-Allow-Origin", "*");//允许所有来源访同
        System.out.println("user = " + user);
        UserInfo<PageInfo<Users>> page = new UserInfo<>();
        try {
            page.setCode(200);
            page.setSuccess(true);
            page.setMessages("查询成功");
            PageInfo<Users> pageInfo = userservice.getListUsers(pageNum, pageSize, user);
            page.setUserInfo(pageInfo);
            return JSON.toJSONString(page);
        } catch (Exception e) {
            page.setCode(500);
            page.setSuccess(false);
            page.setMessages("查询失败");
            page.setUserInfo(null);

            return JSON.toJSONString(page);

        }


    }

    @GetMapping("/gl/saleOrder/{pageNum}/{pageSize}")
    public String getsaleOrder(@PathVariable Integer pageNum, @PathVariable Integer pageSize,   SaleOrder saleOrder ) {
        System.out.println("saleOrder.getDjlsh() = " + saleOrder.getDjlsh());
        ResponseInfo<PageInfo<SaleOrder>> saleOrderInfo = new ResponseInfo<>();
       try{
           saleOrderInfo.setCode(200);
           saleOrderInfo.setSuccess(true);
           saleOrderInfo.setMessages("获取成功");
           PageInfo<SaleOrder> saleOrderPageInfo = userservice.getsaleOrder(pageNum,pageSize,saleOrder);
           saleOrderInfo.setData(saleOrderPageInfo);
           return JSON.toJSONString(saleOrderInfo);

       }catch (Exception e){
           StringWriter stringWriter= new StringWriter();
           PrintWriter writer= new PrintWriter(stringWriter);
           e.printStackTrace(writer);
           StringBuffer buffer= stringWriter.getBuffer();
           saleOrderInfo.setCode(500);
           saleOrderInfo.setSuccess(false);
           saleOrderInfo.setMessages("查询失败");
           //查询失败的异常信息封装返回到前台
          saleOrderInfo.setError_info(buffer.toString());
           saleOrderInfo.setData(null);

           return JSON.toJSONString(saleOrderInfo);

       }


    }

    @GetMapping("/gl/out-api/{username}/{password}/it")
    public String getToken(@PathVariable String username, @PathVariable String password) {
        String token = TokenUtils.token(username, password);
        boolean flag = TokenUtils.verify(token);
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setTokens(token);
        if (flag) {

            tokenInfo.setMessages("获取成功");
            tokenInfo.setFlag(true);
        } else {
            tokenInfo.setMessages("获取失败");
            tokenInfo.setFlag(false);

        }
        return JSON.toJSONString(tokenInfo);


    }
}
