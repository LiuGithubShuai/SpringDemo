package com.kaishengit.service;

import com.kaishengit.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */
@Service
public interface UserService {

    void save(User user);
    void update(User user);
    void del(Integer id);
    void findById(Integer id);
    List<User> findAll();
    Long count();

}
