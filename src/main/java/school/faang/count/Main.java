package school.faang.count;

import school.faang.count.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {

        addStudent(STUDENTS, new Student("John", "Science", 21));
        addStudent(STUDENTS, new Student("Jack", "Data Science", 25));
        addStudent(STUDENTS, new Student("Will", "Physics", 25));
        addStudent(STUDENTS, new Student("John", "Computer Science", 21));

        Map<facultyAndYear, List<Student>> studentMap = createFacultyAndYearMap(STUDENTS);

        findFaculty(studentMap, "Computer Science", 21);

    }

    public static HashMap<facultyAndYear, List<Student>> createFacultyAndYearMap(List<Student> students) {
        Map<facultyAndYear, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            facultyAndYear key = new facultyAndYear(student.getFaculty(), student.getYear());
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return new HashMap<>(map);
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        students.removeIf(s -> s.equals(student));
    }

    public static void findFaculty(Map<facultyAndYear, List<Student>> studentMap, String faculty, int year) {
        for (Map.Entry<facultyAndYear, List<Student>> student : studentMap.entrySet()) {

            facultyAndYear key = new facultyAndYear(student.getKey().getFaculty(), student.getKey().getYear());

            if (student.getKey().equals(key.getCombineFacultyAndYear())) {
                System.out.println(student.getValue());
            }
        }
    }
}
