package faang.school.godbless.hashMap.countingAbsences;

import lombok.Data;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be empty");
        }
        if (faculty == null || faculty.isEmpty() || faculty.isBlank()) {
            throw new IllegalArgumentException("Faculty can`t be empty");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", faculty: " + faculty + ", year: " + year;
    }
}