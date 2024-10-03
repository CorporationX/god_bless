package school.faang.truancy;

import school.faang.truancy.classes.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, List<Student>> studentsMap;

    public static Map<String, List<Student>> listStudentsToMap(List<Student> studentList) {
        Map<String, List<Student>> studentMap = new HashMap<>();
        for(Student student : studentList) {
            String key = student.getFaculty() + student.getYear();
            studentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return studentMap;
    }

    public static void addNewStudent(Student student) {
        String key = student.getFaculty() + student.getYear();
        studentsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
    }

    public static void deleteStudent(String name, String faculty, Integer year) {
        Student deleteStudent = new Student(name, faculty, year);
        String key = faculty + year;
        studentsMap.get(key).remove(deleteStudent);
    }

    public static void findAllStudentsByFacultyAndYear(String faculty, Integer year) {
        String key = faculty + year;
        System.out.println(studentsMap.get(key));
    }

    public static void displayAllStudentsGroupByFacultyAndYear() {
        for(Map.Entry<String, List<Student>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Sergey", "RP", 1));
        studentList.add(new Student("Kolia", "RP", 1));
        studentList.add(new Student("Ivan", "RP", 3));
        studentList.add(new Student("Ura", "GEO", 2));
        studentList.add(new Student("Dasha", "MATH", 4));
        studentsMap = listStudentsToMap(studentList);
        addNewStudent(new Student("Dima", "RP", 4));
        addNewStudent(new Student("Anna", "RP", 1));
        deleteStudent("Ivan", "RP", 3);
        displayAllStudentsGroupByFacultyAndYear();
        findAllStudentsByFacultyAndYear("RP", 1);
    }
}