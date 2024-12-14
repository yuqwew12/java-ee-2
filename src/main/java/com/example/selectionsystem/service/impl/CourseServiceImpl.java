package com.example.selectionsystem.service.impl;

import com.example.selectionsystem.dao.CourseMapper;
import com.example.selectionsystem.model.Course;
import com.example.selectionsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourses() {

        return courseMapper.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) {
        return courseMapper.getCourseById(id);
    }

    @Override
    public void addCourse(Course course) {
        courseMapper.insertCourse(course);
    }
}
