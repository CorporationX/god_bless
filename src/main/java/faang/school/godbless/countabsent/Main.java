package countabsent;

import faang.school.godbless.countabsent.Student;
import faang.school.godbless.countabsent.StudentStream;

import java.util.*;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("Ali", "IT", 2024);
        addStudent("John", "Robotics", 2020);
        addStudent("David", "ML", 2023);
        addStudent("Peter", "Robotics", 2020);
        addStudent("Alex", "Robotics", 2021);
        Map<StudentStream, List<Student>> result = getStudents(students);
        for (Map.Entry<StudentStream, List<Student>> item : result.entrySet()) {
            System.out.println(item.getKey().toString() + " " + item.getValue().size());
        }
        Student foundStudent = findStudent("Peter", "Robotics", 2020);
        System.out.println(foundStudent.toString());
        findByStream("Robotics",2021).forEach(el->{
            System.out.println("Sorted "+el.toString());
        });
        deleteStudent("David", "ML", 2023);
    }
    private static void deleteStudent(String name, String faculty, Integer year) {
        List<Student> res = new ArrayList<>();
        res = students.stream()
                .filter(el -> !el.getName().equals(name) && !el.getFaculty().equals(faculty) && !el.getYear().equals(year)).toList();
    }
    private static void addStudent(String name, String faculty, Integer year) {
        students.add(new Student(name, faculty, year));
    }

    private static Student findStudent(String name, String faculty, Integer year) {
        Optional<Student> result = students
                .stream()
                .filter(el -> el.getName().equals(name) && el.getFaculty().equals(faculty) && el.getYear().equals(year)).findFirst();
        return result.orElse(null);
    }
    private static List<Student> findByStream(String faculty,Integer year) {
        List<Student> res = students
                .stream()
                .filter(el->el.getFaculty().equals(faculty) && el.getYear().equals(year)).toList();
        return res;
    }
    private static Map<StudentStream, List<Student>> getStudents(List<Student> studentsToSearch) {
        Map<StudentStream, List<Student>> res = new HashMap<>();
        studentsToSearch.forEach(student -> {
            StudentStream studentStream = new StudentStream(student.getFaculty(), student.getYear());
            List<Student> filteredStudents = studentsToSearch.stream().filter(el -> el.getFaculty().equals(student.getFaculty()) && el.getYear().equals(student.getYear())).toList();
            res.computeIfAbsent(studentStream, k -> filteredStudents);
        });
        return res;
    }
}
