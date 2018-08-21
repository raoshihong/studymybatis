package com.rao.study.mybatis.xml.service;

import com.rao.study.mybatis.xml.domain.Student;

import java.util.List;

public interface StudentService {
    void insertStudent(Student student);
    void updateStudent(Student student);
    void queryStudent(Student student);
    void deleteStudent(Student student);
    Student queryStudent(Integer id);
}
