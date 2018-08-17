package com.rao.study.mybatis.xml;

import com.rao.study.mybatis.xml.domain.User;
import com.rao.study.mybatis.xml.mapper.UserMapper;
import com.rao.study.mybatis.xml.service.JdbcOperation;
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
