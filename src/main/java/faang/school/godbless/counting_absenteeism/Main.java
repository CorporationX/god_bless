package faang.school.godbless.counting_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        addStudent(new Student("Dmitriy", "Mechanical engineering", 3));
        addStudent(new Student("Sofia", "Management", 2));
        addStudent(new Student("Lubov", "Programming", 3));
        addStudent(new Student("Egor", "Mechanical engineering", 1));
        addStudent(new Student("Petr", "Programming", 3));
        addStudent(new Student("Vadim", "Management", 2));

        Map<FacultyAndYear, List<Student>> groupsStudents = groupStudentsByFacultyAndYear(students);

        System.out.println(students);
        removeStudent("Dmitriy", "Mechanical engineering", 3);
        System.out.println(students);
        System.out.println(getStudentsByFacultyAndYear(groupsStudents, "Programming", 3));
        getAllStudentsGroupedByFacultyAndYear(groupsStudents);
    }

    public static Map<FacultyAndYear, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<FacultyAndYear, List<Student>> studentsByFacultyAndYear = new HashMap<>();

        for (Student student : students) {
            studentsByFacultyAndYear.computeIfAbsent(new FacultyAndYear(student.getFaculty(), student.getYear()),
                    s -> new ArrayList<>()).add(student);
        }
        return studentsByFacultyAndYear;
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public static void removeStudent(String name, String faculty, int year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> getStudentsByFacultyAndYear(Map<FacultyAndYear, List<Student>> studentsByFacultyAndYear,
                                                            String faculty, int year) {
        return studentsByFacultyAndYear.get(new FacultyAndYear(faculty, year));
    }

    public static void getAllStudentsGroupedByFacultyAndYear(Map<FacultyAndYear, List<Student>> studentsByFacultyAndYear) {
        for (var entry : studentsByFacultyAndYear.entrySet()) {
            System.out.println("[" + entry.getKey().getFaculty() + ", " + entry.getKey().getYear() + "] : "
                    + entry.getValue());
        }
    }
}
