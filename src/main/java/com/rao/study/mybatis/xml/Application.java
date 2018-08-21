package com.rao.study.mybatis.xml;

import com.rao.study.mybatis.xml.domain.User;
import com.rao.study.mybatis.xml.service.UserService;
import com.rao.study.mybatis.xml.service.impl.UserServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Application {

    public static void main(String[] args){
        UserService userService = new UserServiceImpl();
//        User user = new User();
//        user.setName("fs");
//        userService.insertUser(user);

//        user.setId(4);
//        user.setBirthday(new Date());
//        user.setSalary(new BigDecimal(20.20));
//        userService.updateUser(user);
//
//        user.setId(7);
//        userService.deleteUser(user);

        List<User> users = userService.queryByName("ss");
        users.forEach(u->System.out.println(u.getName()+"->"+u.getId()));
    }

}
