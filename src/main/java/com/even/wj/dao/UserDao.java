package com.even.wj.dao;

import com.even.wj.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    //根据用户名查询用户
    User findUserByUsername(String username);

    //根据用户名和密码查询用户
    User getByUsernameAndPassword(String username, String password);
}
