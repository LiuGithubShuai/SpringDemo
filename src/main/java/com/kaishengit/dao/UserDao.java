package com.kaishengit.dao;

import com.kaishengit.pojo.User;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
public interface UserDao {


    void save(User user);
    void update(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> findAll();
    Long count();


}
