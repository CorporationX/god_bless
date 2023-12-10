package faang.school.godbless.students_absence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students;
    private static Map<String, List<Student>> studentMap;
    private static String yearOfFaculty;

    public static void main(String[] args) {
        Student student1 = new Student("Alice", "Engineering", 2019);
        Student student2 = new Student("Mike", "Engineering", 2019);
        Student student3 = new Student("George", "Economic", 2020);
        Student student4 = new Student("Ann", "Biological", 2021);
        Student student5 = new Student("Andrew", "Economic", 2022);

        students = List.of(student1, student2, student3, student4);
        studentMap = sortStudentsByFaculty(students);

        addStudent(student5);
        deleteStudent(student2);
        getStudentByFacultyAndYear("Economic", 2022);
        getAllGroupedStudent();
    }

    public static Map<String, List<Student>> sortStudentsByFaculty(List<Student> list) {

        Map<String, List<Student>> sortedByFaculty = new HashMap<>();

        for (Student student : list) {
            yearOfFaculty = student.getFaculty() + " " + student.getYear();
            sortedByFaculty.putIfAbsent(yearOfFaculty, new ArrayList<>());
            sortedByFaculty.get(yearOfFaculty).add(student);
        }
        return sortedByFaculty;
    }

    public static void addStudent(Student student) {
        yearOfFaculty = student.getFaculty() + " " + student.getYear();
        studentMap.putIfAbsent(yearOfFaculty, new ArrayList<>());
        studentMap.get(yearOfFaculty).add(student);
        students.add(student);
    }

    public static void deleteStudent(Student student) {
        studentMap.get(student.getFaculty() + " " + student.getYear()).remove(student);
    }

    public static void getStudentByFacultyAndYear(String faculty, int year) {
        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            if (entry.getKey().equals(faculty + " " + year)) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public static void getAllGroupedStudent() {
        for (Map.Entry<String, List<Student>> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": ");
            for (Student s : entry.getValue()) {
                System.out.println(s.getName());
            }
        }
    }
}
