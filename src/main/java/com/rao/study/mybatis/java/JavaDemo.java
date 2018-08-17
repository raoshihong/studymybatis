package com.rao.study.mybatis.java;

import com.rao.study.mybatis.java.domain.User;
import com.rao.study.mybatis.java.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class JavaDemo {

    public static void main(String[] args){
        SqlSessionFactory sqlSessionFactory = JdbcOperation.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("ssss");
        userMapper.insert(user);
        sqlSession.commit();
    }

}
