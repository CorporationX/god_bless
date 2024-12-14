package faang.school.godbless.counting_absences;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (faculty.contains("#")) {
            throw new RuntimeException("Faculty Name should not contain '#' characters");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
}
