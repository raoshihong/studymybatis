package com.rao.study.mybatis.xml.service;

import com.rao.study.mybatis.xml.domain.User;

public interface UserService {
    void insertUser(User user);
    void updateUser(User user);
    User queryUser(User user);
    void deleteUser(User user);
}
