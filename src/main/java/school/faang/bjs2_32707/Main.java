package school.faang.bjs2_32707;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final Map<String, List<Student>> GROUPED_STUDENTS = new HashMap<>();
    static List<Student> students = new ArrayList<>();

    static void groupStudents() {
        for (Student student : students) {
            String facultyYearKey = student.getFaculty() + " " + student.getYear();
            if ((GROUPED_STUDENTS.get(facultyYearKey) == null ||
                    !GROUPED_STUDENTS.get(facultyYearKey).contains(student))) {
                GROUPED_STUDENTS.computeIfAbsent(facultyYearKey, key -> new ArrayList<>()).add(student);
            }
        }
    }

    static void addStudent(String name, String faculty, int year) {
        Student newStudent = new Student(name, faculty, year);
        if (!students.contains(newStudent)) {
            students.add(newStudent);
            groupStudents();
        }
    }

    static void deleteStudent(String name, String faculty, int year) {
        Student targetStudent = new Student(name, faculty, year);
        String facultyYearKey = faculty + " " + year;

        if (students.contains(targetStudent)) {
            students.remove(targetStudent);
            GROUPED_STUDENTS.get(facultyYearKey).remove(targetStudent);
        }
    }

    static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        String facultyYearKey = faculty + " " + year;
        return GROUPED_STUDENTS.getOrDefault(facultyYearKey, null);
    }

    static void printAllGroupedStudents() {
        for (var entry : GROUPED_STUDENTS.entrySet()) {
            System.out.println("Студенты факультета и курса " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.print(student.getName() + " | ");
            }
            System.out.println();
            System.out.println("-".repeat(20));
        }
    }
}
