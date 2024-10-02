package ru.kraiush.BJS2_32409;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Student {
    private String name;
    private StudyInfo studyInfo;

    public Student(String name, StudyInfo studyInfo) {
        this.name = name;
        this.studyInfo = studyInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(studyInfo, student.studyInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studyInfo);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
