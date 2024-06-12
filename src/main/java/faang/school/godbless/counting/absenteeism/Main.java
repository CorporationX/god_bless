package faang.school.godbless.counting.absenteeism;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


    private static List<Student> students = new ArrayList<>();

    public static void addStudent(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        }
        else {
            System.err.println("Error!");
        }

    }

    public static void removeStudent(String name, String faculty, LocalDate year) {
        students.removeIf(student -> student.equals(new Student(name, faculty, year)));
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear() {
        HashMap<String, List<Student>> groupedStudents = new HashMap<>();
        for(Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            groupedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return groupedStudents;
    }

    public static void printGroupedStudents() {
        Map<String, List<Student>> groupedStudents = groupStudentsByFacultyAndYear();
        for(Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Faculty-Year: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
        }
    }
    public static void main(String[] args) {

        addStudent(new Student("name1", "faculty1", LocalDate.of(2024, 6,6)));
        addStudent(new Student("name2", "faculty2", LocalDate.of(2024, 5,6)));
        addStudent(new Student("name3", "faculty3", LocalDate.of(2024, 4,6)));
        addStudent(new Student("name4", "faculty1", LocalDate.of(2024, 6,6)));
        addStudent(new Student("name5", "faculty2", LocalDate.of(2024, 5,6)));
        removeStudent("name3", "faculty3", LocalDate.of(2024, 4,6));
        for(Student student : students) {
            System.out.println(student.toString());
        }

        printGroupedStudents();

    }
}
