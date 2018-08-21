package com.rao.study.mybatis.xml.mapper;

import com.rao.study.mybatis.xml.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByName(@Param("user_name") String name); //使用@Param指定参数名称,如果没有，这里的List<User>
}