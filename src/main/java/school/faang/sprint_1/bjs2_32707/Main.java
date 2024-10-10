package school.faang.sprint_1.bjs2_32707;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    static final Map<String, Set<Student>> GROUPED_STUDENTS = new HashMap<>();
    static final Set<Student> STUDENTS = new HashSet<>();
    static String searchKey;

    static void groupStudents() {
        for (Student student : STUDENTS) {
            searchKey = createSearchKey(student.getFaculty(), student.getYear());
            GROUPED_STUDENTS.computeIfAbsent(searchKey, key -> new HashSet<>()).add(student);
        }
    }

    public static void addStudent(String name, String faculty, int year) {
        Student newStudent = new Student(name, faculty, year);
        searchKey = createSearchKey(faculty, year);

        STUDENTS.add(newStudent);
        GROUPED_STUDENTS.computeIfAbsent(searchKey, key -> new HashSet<>()).add(newStudent);
    }

    public static void deleteStudent(String name, String faculty, int year) {
        Student targetStudent = new Student(name, faculty, year);
        searchKey = createSearchKey(faculty, year);

        if (STUDENTS.remove(targetStudent)) {
            GROUPED_STUDENTS.get(searchKey).remove(targetStudent);
        }
    }

    public static Set<Student> findStudentsByFacultyAndYear(String searchKey) {
        return GROUPED_STUDENTS.getOrDefault(searchKey, new HashSet<>());
    }

    public static void printAllGroupedStudents() {
        for (var entry : GROUPED_STUDENTS.entrySet()) {
            System.out.println("Студенты факультета и курса " + entry.getKey() + ":");
            for (Student student : entry.getValue()) {
                System.out.print(student.getName() + " | ");
            }
            System.out.println();
            System.out.println("-".repeat(20));
        }
    }

    public static String createSearchKey(String faculty, int year) {
        return (faculty + " " + year);
    }
}
