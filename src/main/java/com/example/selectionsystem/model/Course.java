package com.example.selectionsystem.model;

public class Course {
    private int id;
    private String name;
    private int  max_students;
    private int  current_students;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxStudents() {
        return  max_students;
    }

    public void setMaxStudents(int  max_students) {
        this. max_students =  max_students;
    }

    public int getCurrentStudents() {
        return  current_students;
    }

    public void setCurrentStudents(int  current_students) {
        this. current_students =  current_students;
    }
}
