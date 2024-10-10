package school.faang.truancy;

import school.faang.truancy.classes.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Student> students = new ArrayList<>();

    public static Map<String, List<Student>> listStudentsToMap() {
        Map<String, List<Student>> studentMap = new HashMap<>();
        for(Student student : students) {
            String key = student.getFaculty() + student.getYear();
            studentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return studentMap;
    }

    public static void addNewStudent(Student student) {
        students.add(student);
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        Student deleteStudent = new Student(name, faculty, year);
        students.remove(deleteStudent);
    }

    public static void findAllStudentsByFacultyAndYear(String faculty, Integer year) {
        String key = faculty + year;
        System.out.println(listStudentsToMap().get(key));
    }

    public static void displayAllStudentsGroupByFacultyAndYear() {
        for(Map.Entry<String, List<Student>> entry : listStudentsToMap().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        students.add(new Student("Sergey", "RP", 1));
        students.add(new Student("Kolia", "RP", 1));
        students.add(new Student("Ivan", "RP", 3));
        students.add(new Student("Ura", "GEO", 2));
        students.add(new Student("Dasha", "MATH", 4));

        System.out.println(listStudentsToMap());
        addNewStudent(new Student("Dima", "RP", 4));
        addNewStudent(new Student("Anna", "RP", 1));
        deleteStudent("Ivan", "RP", 3);
        displayAllStudentsGroupByFacultyAndYear();
        findAllStudentsByFacultyAndYear("RP", 1);
    }
}