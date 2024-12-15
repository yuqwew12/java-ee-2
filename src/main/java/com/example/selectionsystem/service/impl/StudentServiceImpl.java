package com.example.selectionsystem.service.impl;

import com.example.selectionsystem.dao.StudentMapper;
import com.example.selectionsystem.model.Student;
import com.example.selectionsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentMapper.getStudentByName(name);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.insertStudent(student);
    }

    @Override
    public boolean authenticate(String name, String password) {
        Student student = studentMapper.getStudentByName(name);
        return student != null && student.getPassword().equals(password);
    }
    @Override
    public boolean isUsernameExists(String name) {
        return studentMapper.isUsernameExists(name);
    }
}
