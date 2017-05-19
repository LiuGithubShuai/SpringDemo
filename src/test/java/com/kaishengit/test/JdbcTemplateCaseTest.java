package com.kaishengit.test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JdbcTemplateCaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void save(){
        User user = new User("后面","书柜");
        userDao.save(user);
    };

    @Test
    public void update(){
        User user = userDao.findById(15);
        user.setUserName("蓝色");
        user.setPassword("短袖");
        userDao.update(user);
    }

    @Test
    public void del(){
        userDao.delete(16);
    }

    @Test
    public void findAll(){
        List<User> userList = userDao.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void count(){
        Long n = userDao.count();
        System.out.println(n);
    }



}
