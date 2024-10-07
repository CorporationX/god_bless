package university.student;

import java.util.Objects;

public class Student {
    private final String name;
    private final String grade;
    private final int year;

    public Student(String name, String grade, int year) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя студента не может быть пустым");
        }
        if (grade == null || grade.isEmpty()) {
            throw new IllegalArgumentException("Факультет не может быть пустым");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("Курс должен быть положительным числом");
        }
        this.name = name;
        this.grade = grade;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getGrade() {
        return this.grade;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year == student.year && name.equals(student.name) && grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade, year);
    }

    public String toString() {
        return "Student(name=" + this.getName() + ", grade=" + this.getGrade() + ", year=" + this.getYear() + ")";
    }
}

