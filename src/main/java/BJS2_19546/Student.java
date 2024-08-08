package BJS2_19546;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private String faculty;
    private int year;
    private static Map<String, Map<Integer, List<Student>>> groupedStudents = new HashMap<>();
    public static List<Student> studentsStorage = new ArrayList<>();

    public static void groupStudentsByFacultyAndYear() {
        for (Student student : studentsStorage) {
            String faculty = student.getFaculty();
            int year = student.getYear();

            if (!groupedStudents.containsKey(faculty)) {
                groupedStudents.put(faculty, new HashMap<>());
            }

            Map<Integer, List<Student>> yearGroup = groupedStudents.get(faculty);
            if (!yearGroup.containsKey(year)) {
                yearGroup.put(year, new ArrayList<>());
            }
            yearGroup.get(year).add(student);
        }
    }

    public static void getStudentsByFacultyAndYear(String name, String faculty, int year) {
        for (Student student : studentsStorage) {
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year) {
                System.out.printf("%s: %s, %d%n", student.getName(), student.getFaculty(), student.getYear());
                break;
            } else {
                System.out.println("Студент не найден.");
            }
        }
    }

    public static void removeStudent(String name, String faculty, int year) {
        for (Student student : studentsStorage) {
            if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year) {
                String studentName = student.getName();
                studentsStorage.remove(student);
                System.out.printf("Студент успешно удален: %s", studentName);
                break;
            }
        }
    }

    public static void printStudents() {
        for (String faculty : groupedStudents.keySet()) {
            System.out.printf("Факультет: %s%n", faculty);

            Map<Integer, List<Student>> yearMap = groupedStudents.get(faculty);

            for (int year : yearMap.keySet()) {
                System.out.printf("  Год: %s%n", year);

                List<Student> studentList = yearMap.get(year);
                for (Student student : studentList) {
                    System.out.printf("    Студент: %s%n", student.getName());
                }
            }
        }
    }
}