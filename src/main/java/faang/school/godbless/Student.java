package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (faculty == null || faculty.isEmpty()) {
            throw new IllegalArgumentException("faculty cannot be null or empty");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Faculty: " + faculty + ", Year: " + year;
    }
}