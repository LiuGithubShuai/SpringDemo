package com.kaishengit.dao.impl;

import com.kaishengit.dao.UserDao;
import com.kaishengit.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Override
    public User findById(Integer id) {
        String sql = "select * from t_accoun where id = #{id}";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        },id);
    }*/

    @Override
    public User findById(Integer id){
        String sql = "select * from t_account where id = ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    /*@Override
    public List<User> findAll() {
        String sql = "select * from t_account";
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
    }*/

    @Override
    public List<User> findAll(){
        String sql = "select * from t_account";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public Long count() {
        String sql = "select count(*) from t_account";
        return jdbcTemplate.queryForObject(sql,new SingleColumnRowMapper<Long>());
    }

    @Override
    public void save(User user) {
        String sql = "insert into t_account (userName,password) values (?,?)";
        jdbcTemplate.update(sql,user.getUserName(),user.getPassword());
    }

    @Override
    public void update(User user) {
        String sql = "update t_account set userName = ? , password = ? where id = ?";
        jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from t_account where id = ?";
        jdbcTemplate.update(sql,id);
    }
}
