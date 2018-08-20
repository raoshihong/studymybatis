package com.rao.study.mybatis.xml.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * Mybatis插件拦截器:可以拦截mybatis执行的某个阶段的执行sql语句
 * 自定义Mybatis插件拦截器步骤:
 *
 */

//这个指定在执行语句之前进行拦截
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class StatementHandlerInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler obj = (StatementHandler) invocation.getTarget();//获取拦截的目标对象,上面拦截的是StatementHandler类，所以返回的对象就是StatementHandler对象
        System.out.println("ResultSetHandlerInterceptor 拦截");
        System.out.println(obj.getBoundSql().getSql());
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o,this);//进行动态代理,所以会调用上面的intercept方法
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
    }
}
