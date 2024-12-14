package com.example.selectionsystem.dao;

import com.example.selectionsystem.model.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student getStudentById(@Param("id") int id);

    @Select("SELECT * FROM students WHERE name = #{name}")
    Student getStudentByName(@Param("name") String name);

    @Insert("INSERT INTO students (name, password) VALUES (#{name}, #{password})")
    void insertStudent(Student student);
}
