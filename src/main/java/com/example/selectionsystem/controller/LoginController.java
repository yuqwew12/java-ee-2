package com.example.selectionsystem.controller;

import com.example.selectionsystem.model.Student;
import com.example.selectionsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView authenticate(@RequestParam String name, @RequestParam String password, HttpSession session) {
        if (studentService.authenticate(name, password)) {
            Student student = studentService.getStudentByName(name);
            session.setAttribute("user", student);
            return new ModelAndView("redirect:/selectCourse");
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }
}
