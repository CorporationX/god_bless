package faang.school.godbless.countabsent;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String faculty;
    private Integer year;

    public Student(String name, String faculty, Integer year) {
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year=" + year +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public Integer getYear() {
        return year;
    }

}
