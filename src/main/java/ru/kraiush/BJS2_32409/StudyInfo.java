package ru.kraiush.BJS2_32409;

import lombok.Getter;

import java.util.Objects;

@Getter
public class StudyInfo {
    private String faculty;
    private int year;

    public StudyInfo(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudyInfo studyInfo = (StudyInfo) o;
        return year == studyInfo.year && Objects.equals(faculty, studyInfo.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(faculty, year);
    }

    @Override
    public String toString() {
        return "\nFaculty: " + faculty + ", year: " + year + "\n" + "Students";
    }
}
