package school.faang.students;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public void add(Student student) {
        students.add(student);
    }

    public void delete(String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public List<Student> findAllByFacultyAndYear(String faculty, Integer year) {
        return Student.groupStudentsByFacultyAndYear(students).get(new FacultyYearKey(faculty, year));
    }

    public void printAllStudents() {
        Student.groupStudentsByFacultyAndYear(students).forEach(
                (facultyYearKey, students) -> {
                    System.out.println("Faculty and Year: " + facultyYearKey);
                    students.forEach(student -> System.out.println(" - " + student));
                }
        );
    }
}
