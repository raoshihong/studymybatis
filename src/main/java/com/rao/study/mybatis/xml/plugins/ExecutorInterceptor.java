package com.rao.study.mybatis.xml.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 使用@Intercepts指定拦截器
 * 使用@Signature指定方法签名,type表示类,method是指拦截哪个方法,args表示拦截的方法参数类型
 */
@Intercepts({@Signature(type = Executor.class,method = "update",args = {MappedStatement.class,Object.class})})
public class ExecutorInterceptor implements Interceptor {//实现Interceptor接口，并实现三个方法
    @Override
    public Object intercept(Invocation invocation) throws Throwable {//关键方法,在这里拦截,并判断是否放行,放行代码：invocation.proceed() ,实际上是调用目标方法
        Executor obj = (Executor) invocation.getTarget();//获取被拦截的目标对象
        Method method = invocation.getMethod();//获取被拦截的目标方法

        System.out.println("ExecutorInterceptor 拦截");

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {//设置动态代理
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {//拦截器回调时,会将环境变量中的属性值传递到这个方法

    }
}
