package com.rao.study.mybatis.xml.service.impl;

import com.rao.study.mybatis.xml.config.MyBatisConfig;
import com.rao.study.mybatis.xml.domain.Student;
import com.rao.study.mybatis.xml.mapper.StudentMapper;
import com.rao.study.mybatis.xml.mapper.UserMapper;
import com.rao.study.mybatis.xml.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

    @Override
    public void insertStudent(Student student) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        studentMapper.insert(student);
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void queryStudent(Student student) {

    }

    @Override
    public void deleteStudent(Student student) {

    }

    @Override
    public Student queryStudent(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        return studentMapper.selectStudentAndCard(id);
    }
}
