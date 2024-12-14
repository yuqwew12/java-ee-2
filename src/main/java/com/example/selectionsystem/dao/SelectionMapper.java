package com.example.selectionsystem.dao;

import com.example.selectionsystem.model.Selection;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SelectionMapper {

    @Select("SELECT * FROM selections WHERE student_id = #{studentId}")
    List<Selection> getSelectionsByStudentId(@Param("studentId") int studentId);

    @Insert("INSERT INTO selections (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    void insertSelection(Selection selection);
}
