package com.example.selectionsystem.service.impl;

import com.example.selectionsystem.dao.CourseMapper;
import com.example.selectionsystem.dao.SelectionMapper;
import com.example.selectionsystem.model.Course;
import com.example.selectionsystem.model.Selection;
import com.example.selectionsystem.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
/**
 * 实现SelectionService接口的服务类
 */
public class SelectionServiceImpl implements SelectionService {

    @Autowired
    /**
     * 用于操作选课信息的Mapper
     */
    private SelectionMapper selectionMapper;

    @Autowired
    /**
     * 用于操作课程信息的Mapper
     */
    private CourseMapper courseMapper;

    @Override
    /**
     * 根据学生ID获取选课列表
     * @param studentId 学生ID
     * @return 选课列表
     */
    public List<Selection> getSelectionsByStudentId(int studentId) {
        return selectionMapper.getSelectionsByStudentId(studentId);
    }

    @Override
    @Transactional
    /**
     * 学生选课方法
     * 在课程未满的情况下，为学生选课并更新课程人数
     * @param studentId 学生ID
     * @param courseId 课程ID
     * @return 选课是否成功
     */
    public boolean selectCourse(int studentId, int courseId) {
        Course course = courseMapper.getCourseById(courseId);
        if (course.getCurrentStudents() >= course.getMaxStudents()) {
            // 课程已满，选课失败
            return false;
        }
        // 更新课程当前学生人数
        course.setCurrentStudents(course.getCurrentStudents() + 1);
        courseMapper.updateCourse(course);

        // 创建并插入选课记录
        Selection selection = new Selection();
        selection.setStudentId(studentId);
        selection.setCourseId(courseId);
        selectionMapper.insertSelection(selection);
        // 选课成功
        return true;
    }
}

