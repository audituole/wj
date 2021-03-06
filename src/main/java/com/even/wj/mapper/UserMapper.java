package com.even.wj.mapper;

import com.even.wj.domain.User;

public interface UserMapper {

    //根据用户名查询用户
    User findUserByUsername(String username);
    //根据用户名和密码查询用户
    User getByUsernameAndPassword(String username, String password);
}
