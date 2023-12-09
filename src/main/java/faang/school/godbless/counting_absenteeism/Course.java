package faang.school.godbless.counting_absenteeism;

import lombok.Data;

@Data
public class Course {
    private String faculty;
    private int year;

    public Course(String faculty, int year) {
        this.faculty = faculty;
        this.year = year;
    }
}
