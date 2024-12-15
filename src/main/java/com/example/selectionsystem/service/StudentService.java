package com.example.selectionsystem.service;

import com.example.selectionsystem.model.Student;

public interface StudentService {
    Student getStudentById(int id);
    Student getStudentByName(String name);
    void addStudent(Student student);
    boolean isUsernameExists(String name); // 新增的方法
    boolean authenticate(String name, String password);
}
