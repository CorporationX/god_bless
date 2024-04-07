package faang.school.godbless.university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        addStudent("Mark", "CS", 4);
        addStudent("Michael", "Biology", 1);
        addStudent("Leonardo", "CS", 2);
        addStudent("Sandra", "CS", 2);
        addStudent("Elena", "Biology", 1);
        addStudent("Bob", "CS", 2);
        addStudent("Bill", "Biology", 1);
        addStudent("Clod", "Biology", 3);

        deleteStudent("Mark", "CS", 4);

        searchAllStudent("CS", 2);

        printAllStudents();
    }

    private static void printAllStudents() {
        Map<GroupOfStudents, List<Student>> facultyAndYear = groupByFacultyAndYear();

        for (Map.Entry<GroupOfStudents, List<Student>> entry : facultyAndYear.entrySet()) {
            GroupOfStudents group = entry.getKey();
            List<Student> students = entry.getValue();

            System.out.println("Faculty: " + group.getFaculty() + ", Year: " + group.getYear());

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void addStudent(String name, String faculty, int year) {
        studentList.add(new Student(name, faculty, year));
    }

    private static void deleteStudent(String name, String faculty, int year) {
        studentList.remove(new Student(name, faculty, year));
    }

    private static List<Student> searchAllStudent(String faculty, int year) {
        GroupOfStudents groupOfStudents = new GroupOfStudents(faculty, year);
        return groupByFacultyAndYear().get(groupOfStudents);
    }

    public static Map<GroupOfStudents, List<Student>> groupByFacultyAndYear() {
        Map<GroupOfStudents, List<Student>> mapFacultyAndYear = new HashMap<>();

        for (Student student : studentList) {
            List<Student> listFacultyAndYear = new ArrayList<>();
            if (!mapFacultyAndYear.containsKey(student.getFacultyAndYear())) {
                mapFacultyAndYear.put(student.getFacultyAndYear(), listFacultyAndYear);
            }
            mapFacultyAndYear.get(student.getFacultyAndYear()).add(student);
        }
        return mapFacultyAndYear;
    }
}