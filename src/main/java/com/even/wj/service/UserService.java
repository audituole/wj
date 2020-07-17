package com.even.wj.service;

import com.even.wj.dao.UserDao;
import com.even.wj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 功能：查询用户名是否存在
     * @param username
     * @return
     */
    public boolean isExist(String username){
        User user = userDao.findUserByUsername(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    /**
     * 功能：根据用户名与密码查询用户
     * @param username
     * @param password
     * @return
     */
    public User get(String username,String password){
        return userDao.getByUsernameAndPassword(username,password);
    }

    /**
     * 功能：保存用户
     * @param user
     */
    public void add(User user){
        userDao.save(user);
    }
}
