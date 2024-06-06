package faang.school.godbless.BJS2_8179;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student student_1 = new Student("John", "IT", 1);
        Student student_2 = new Student("Ivan", "Marketing", 1);
        Student student_3 = new Student("Mikhail", "IT", 2);
        Student student_4 = new Student("Vlad", "Marketing", 3);
        Student student_5 = new Student("Alex", "IT", 2);
        Student student_6 = new Student("Anna", "Marketing", 4);

        students.add(student_1);
        students.add(student_2);
        students.add(student_3);
        students.add(student_4);
        students.add(student_5);
        students.add(student_6);

        Map<String, List<Student>> studentsMap;

        studentsMap = makeGroupedStudentsMap(students);

        printAllStudents(studentsMap);

        addStudent(studentsMap, new Student("Pavel", "Economics", 1));

        printAllStudents(studentsMap);

        deleteStudent(studentsMap, "Vlad", "Marketing", 3);

        printAllStudents(studentsMap);

        System.out.println(searchStudentsByFacultyAndYear(studentsMap, "IT", 2));
    }

    public static Map<String, List<Student>> makeGroupedStudentsMap(List<Student> students) {
        Map<String, List<Student>> groupedStudentsMap = new HashMap<>();
        if (students != null) {
            groupedStudentsMap = students.stream().collect(Collectors.groupingBy(student -> student.getFaculty() + " " + student.getYear()));
        }
        return groupedStudentsMap;
    }

    public static void addStudent(Map<String, List<Student>> students, Student student) {
        String key = student.getFaculty() + student.getYear();
        if (students.containsKey(key)) {
            students.get(key).add(student);
        } else {
            students.put(key, List.of(student));
        }
    }

    public static void deleteStudent(Map<String, List<Student>> students, String name, String faculty, int year) {
        if (name != null && faculty != null) {
            String key = faculty + " " + year;
            if (students.containsKey(key)) {
                Student student = new Student(name, faculty, year);
                students.get(key).remove(student);
            }
        }
    }

    public static List<Student> searchStudentsByFacultyAndYear(Map<String, List<Student>> students, String faculty, int year) {
        List<Student> studentsSet = List.of();
        if (faculty != null) {
            String key = faculty + " " + year;
            if (students.containsKey(key)) {
                studentsSet = students.get(key);
            }
        }
        return studentsSet;
    }

    public static void printAllStudents(Map<String, List<Student>> students) {
        if (students != null) {
            for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
