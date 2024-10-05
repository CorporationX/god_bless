package school.faang;

import java.util.Objects;

public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setName(String name) {
        this.name = name;
    }


}
