package faang.school.godbless.counting_absences;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Student {
    private String name;
    private String faculty;
    private int year;

    public Student(String name, String faculty, int year) {
        if (faculty.contains("#")) {
            throw new RuntimeException("Faculty Name should not contain '#' characters");
        }
        this.name = name;
        this.faculty = faculty;
        this.year = year;
    }

    public static void addStudentToMap(Map<String, List<Student>> studentMap, Student student) {
        String key = composeKey(student.getFaculty(), student.getYear());
        studentMap.computeIfAbsent(key, composedKey -> new ArrayList<>());
        studentMap.get(key).add(student);
    }

    public static void deleteStudentFromMap(Map<String, List<Student>> studentMap,
                                            String name, String faculty, int year) {
        Student studentToDelete = new Student(name, faculty, year);
        String key = composeKey(faculty, year);
        // Если после удаления студента из факультета -> факультет пустой, то удаляю факультет из map'ы
        List<Student> studentList = studentMap.get(key);
        if (studentList != null) {
            studentList.remove(studentToDelete);
            if (studentList.isEmpty()) {
                studentMap.remove(key);
            }
        }
    }

    public static List<Student> searchByFacultyAndYear(Map<String, List<Student>> studentMap,
                                                       String faculty, int year) {
        String key = composeKey(faculty, year);
        return studentMap.get(key);
    }

    public static void showStudentsGropedByFacultyAndYear(Map<String, List<Student>> studentMap) {
        for (Map.Entry<String, List<Student>> gropedStudents : studentMap.entrySet()) {
            System.out.println("Students in " +
                    gropedStudents.getKey().replace("#", " and ") + " year");
            for (Student student : gropedStudents.getValue()) {
                System.out.println(student);
            }
            System.out.println("End of List");
        }
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            addStudentToMap(result, student);
        }

        return result;
    }

    public static String composeKey(String faculty, int year) {
        return faculty + "#" + year;
    }
}
