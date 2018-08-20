package com.rao.study.mybatis.xml.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConfig {

    private static volatile SqlSessionFactory sqlSessionFactory = null;

    private MyBatisConfig(){}

    public static SqlSessionFactory getSqlSessionFactory(){

        if(sqlSessionFactory==null){
            String resource = "mybatis-config/SqlSessionFactory.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        return sqlSessionFactory;
    }

}
