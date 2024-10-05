package school.faang.HashMaps.countingAbsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Ivan", "Biology", 3));
        students.add(new Student("Pavel", "Mathematics", 1));
        students.add(new Student("Dima", "Psychology", 1));
        students.add(new Student("Andrey", "Mathematics", 1));
        students.add(new Student("Vadim", "Biology", 2));
        students.add(new Student("Michael", "Mathematics", 1));
        students.add(new Student("David", "Biology", 3));

        System.out.println(getStudents(students));

        deleteStudent("Ivan", "Biology", 3);
        System.out.println(searchStudents("Mathematics", 1));
        printStudents();
    }

    public static Map<FacultyYear, List<Student>> getStudents(List<Student> studentList) {
        Map<FacultyYear, List<Student>> map = new HashMap<>();
        for (Student student : studentList) {
            map.computeIfAbsent(new FacultyYear(student.getFaculty(), student.getYear()), x -> new ArrayList<>()).add(student);
        }
        return map;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void deleteStudent(String studentName, String faculty, int year) {
        Student student = new Student(studentName, faculty, year);
        students.removeIf(s -> s.equals(student));
    }

    public static List<Student> searchStudents(String faculty, int year) {
        List<Student> studentsList = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                studentsList.add(student);
            }
        }
        return studentsList;
    }

    public static void printStudents() {
        Map<FacultyYear, List<Student>> map = getStudents(students);
        for (Map.Entry<FacultyYear, List<Student>> entry : map.entrySet()) {
            for (Student student : entry.getValue()) {
                System.out.println(student.getName() + " " + student.getFaculty() + " " + student.getYear());
            }
        }
    }
}
