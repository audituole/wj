package com.even.wj.web;


import com.even.wj.domain.User;
import com.even.wj.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;



@Component
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @CrossOrigin
    @PostMapping("api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser){

        //对html标签进行转换,防止xxs攻击
        String usrName = requestUser.getUsername();
        usrName = HtmlUtils.htmlEscape(usrName);

        if(!Objects.equals("admin",usrName) ||Objects.equals("123456",requestUser.getPassword())){
            logger.info("用户名密码错误");
            return new Result(400);
        }

        return new Result(200);

    }
}
