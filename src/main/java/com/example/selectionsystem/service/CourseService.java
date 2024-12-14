package com.example.selectionsystem.service;

import com.example.selectionsystem.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int id);
    void addCourse(Course course);
}
