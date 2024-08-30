package com.multithreading.tournament;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class School {
    private String name;
    private final List<Student> team = new ArrayList<>();
    private int TotalPoints;

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        if (student != null) {
            team.add(student);
        }
    }
}
