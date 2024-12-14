package com.example.selectionsystem.dao;

import com.example.selectionsystem.model.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("SELECT * FROM courses")
    List<Course> getAllCourses();

    @Select("SELECT * FROM courses WHERE id = #{id}")
    Course getCourseById(@Param("id") int id);

    @Insert("INSERT INTO courses (name, max_students, current_students) VALUES (#{name}, #{maxStudents}, #{currentStudents})")
    void insertCourse(Course course);

    @Update("UPDATE courses SET current_students = #{currentStudents} WHERE id = #{id}")
    void updateCourse(Course course);
}
