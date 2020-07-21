package com.even.wj.web;


import com.even.wj.domain.User;
import com.even.wj.result.Result;
import com.even.wj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Objects;



@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){

        //对html标签进行转换,防止xxs攻击
        String usrName = requestUser.getUsername();
        usrName = HtmlUtils.htmlEscape(usrName);

        //查询用户
        User user = userService.get(usrName,requestUser.getPassword());
        if(user!= null) {
            //用户存在，保存到session，并成功返回
            session.setAttribute("user",user);
            return new Result(200);
        }else {
            return new Result(400);
        }
    }
}
