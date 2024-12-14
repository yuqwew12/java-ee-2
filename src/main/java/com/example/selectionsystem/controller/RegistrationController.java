package com.example.selectionsystem.controller;

import com.example.selectionsystem.model.Student;
import com.example.selectionsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerNewStudent(@RequestParam String name, @RequestParam String password) {
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        studentService.addStudent(student);
        return new ModelAndView("redirect:/login");
    }
}
