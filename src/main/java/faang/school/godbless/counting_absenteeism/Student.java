package faang.school.godbless.counting_absenteeism;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (faculty == null) {
            throw new IllegalArgumentException("Faculty cannot be null");
        }
        if (faculty.isEmpty()) {
            throw new IllegalArgumentException("Faculty cannot be empty");
        }
        if (year < 0) {
            throw new IllegalArgumentException("Year cannot be negative");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
}
