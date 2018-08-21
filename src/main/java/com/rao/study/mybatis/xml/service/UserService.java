package com.rao.study.mybatis.xml.service;

import com.rao.study.mybatis.xml.domain.User;

import java.util.List;

public interface UserService {
    void insertUser(User user);
    void updateUser(User user);
    void queryUser(User user);
    void deleteUser(User user);
    List<User> queryByName(String name);
}
