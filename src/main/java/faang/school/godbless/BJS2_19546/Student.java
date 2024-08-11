package faang.school.godbless.BJS2_19546;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    private static Map<FacultyYearKey, List<Student>> groupedStudents = new HashMap<>();
    public static List<Student> studentsStorage = new ArrayList<>();
    private String name;
    private String faculty;
    private int year;

    public static void groupStudentsByFacultyAndYear() {
        for (Student student : studentsStorage) {
            FacultyYearKey key = new FacultyYearKey(student.getFaculty(), student.getYear());

            if (!groupedStudents.containsKey(key)) {
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }
    }

    public static void getStudentsByFacultyAndYear(String faculty, int year) {
        FacultyYearKey key = new FacultyYearKey(faculty, year);
        List<Student> students = groupedStudents.get(key);

        if (students != null) {
            for (Student student : students) {
                System.out.printf("Студент: %s, Факультет: %s, Год: %d%n", student.getName(), student.getFaculty(), student.getYear());
            }
        } else {
            System.out.println("Студенты не найдены.");
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        FacultyYearKey key = new FacultyYearKey(faculty, year);
        List<Student> students = groupedStudents.get(key);

        if (students != null) {
            students.removeIf(student -> student.getName().equals(name));
            if (students.isEmpty()) {
                groupedStudents.remove(key);
            }
            System.out.printf("Студент успешно удален: %s%n", name);
        }
    }

    public static void printStudents() {
        for (Map.Entry<FacultyYearKey, List<Student>> entry : groupedStudents.entrySet()) {
            FacultyYearKey key = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.printf("Факультет: %s, Год: %d%n", key.getFaculty(), key.getYear());
            for (Student student : students) {
                System.out.printf("  Студент: %s%n", student.getName());
            }
        }
    }
}