package school.faang.students;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class University {
    private List<Student> students;

    public University() {
        this.students = new ArrayList<>();
    }

    public void add(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void delete(String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public List<Student> findAllByFacultyAndYear(String faculty, Integer year) {
        return groupStudentsByFacultyAndYear(students).get(Pair.of(faculty, year));
    }

    public static Map<Pair<String, Integer>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<Pair<String, Integer>, List<Student>> groupStudents = new HashMap<>();

        students.forEach(student ->
                groupStudents
                        .computeIfAbsent(Pair.of(student.getFaculty(), student.getYear()),
                                facultyYearKey -> new ArrayList<>())
                        .add(student)
        );

        return groupStudents;
    }

    public void printAllStudents() {
        groupStudentsByFacultyAndYear(students).forEach(
                (facultyYearKey, students) -> {
                    System.out.println("Faculty and Year: " + facultyYearKey);
                    students.forEach(student -> System.out.println(" - " + student));
                }
        );
    }
}
