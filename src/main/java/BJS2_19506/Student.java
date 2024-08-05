package BJS2_19506;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student (String name, String faculty, int year){
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }
}
