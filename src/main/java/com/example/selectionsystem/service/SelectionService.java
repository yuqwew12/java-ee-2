package com.example.selectionsystem.service;

import com.example.selectionsystem.model.Selection;

import java.util.List;

public interface SelectionService {
    List<Selection> getSelectionsByStudentId(int studentId);
    boolean selectCourse(int studentId, int courseId);
}
