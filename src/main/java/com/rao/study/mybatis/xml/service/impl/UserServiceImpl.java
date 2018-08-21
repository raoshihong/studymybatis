package com.rao.study.mybatis.xml.service.impl;

import com.rao.study.mybatis.xml.config.MyBatisConfig;
import com.rao.study.mybatis.xml.domain.User;
import com.rao.study.mybatis.xml.mapper.UserMapper;
import com.rao.study.mybatis.xml.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert(user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void queryUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        user = userMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public void deleteUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteByPrimaryKey(user.getId());
    }

    @Override
    public List<User> queryByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        return userMapper.selectByName(name);
    }
}
