package com.rao.study.mybatis.xml.mapper;

import com.rao.study.mybatis.xml.domain.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectStudentAndCard(Integer id);
}