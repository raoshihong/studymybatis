package com.rao.study.mybatis.xml.plugins;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

//指定对ResultSetHandler的handleResultSets结果集方法进行拦截,处理查询后的结果集数据
@Intercepts(@Signature(type=ResultSetHandler.class,method = "handleResultSets",args = {Statement.class}))
public class ResultSetHandlerInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        ResultSetHandler obj = (ResultSetHandler) invocation.getTarget();

        System.out.println("ResultSetHandlerInterceptor 拦截");
        MetaObject metaObject = SystemMetaObject.forObject(obj);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("mappedStatement");//通过这个反射,可以获取指定的方法
        BoundSql boundSql = (BoundSql) metaObject.getValue("boundSql");
        System.out.println(boundSql.getSql());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
