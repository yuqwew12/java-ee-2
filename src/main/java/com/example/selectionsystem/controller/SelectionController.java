package com.example.selectionsystem.controller;

import com.example.selectionsystem.model.Course;
import com.example.selectionsystem.model.Selection;
import com.example.selectionsystem.model.Student;
import com.example.selectionsystem.service.CourseService;
import com.example.selectionsystem.service.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SelectionController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private SelectionService selectionService;

    // 处理学生选课请求的控制器方法
    @GetMapping("/selectCourse")
    public ModelAndView selectCourse(HttpSession session) {
        // 从会话中获取当前学生信息
        Student student = (Student) session.getAttribute("user");

        // 如果学生信息为空，表明未登录，重定向到登录页面
        if (student == null) {
            return new ModelAndView("redirect:/login");
        }

        // 获取所有课程信息
        List<Course> courses = courseService.getAllCourses();
        // 获取当前学生已选课程信息
        List<Selection> selections = selectionService.getSelectionsByStudentId(student.getId());

        // 创建模型和视图对象，用于返回选课页面
        ModelAndView modelAndView = new ModelAndView("selectCourse");
        // 将所有课程信息添加到模型中
        modelAndView.addObject("courses", courses);
        // 将当前学生已选课程信息添加到模型中
        modelAndView.addObject("selections", selections);

        // 返回包含课程信息和已选课程信息的模型和视图对象
        return modelAndView;
    }


    @PostMapping("/selectCourse")
    public ModelAndView selectCourse(@RequestParam("courseId[]") int[] courseIds, HttpSession session) {
        Student student = (Student) session.getAttribute("user");
        boolean allSuccess = true;
        for (int courseId : courseIds) {
            boolean success = selectionService.selectCourse(student.getId(), courseId);
            if (!success) {
                allSuccess = false;
                break; // 一旦有课程选择失败，停止进一步尝试
            }
        }
        if (allSuccess) {
            return new ModelAndView("redirect:/selectCourse");
        } else {
            ModelAndView modelAndView = new ModelAndView("selectCourse");
            modelAndView.addObject("error", "One or more courses are full");
            return modelAndView;
        }
    }


}
