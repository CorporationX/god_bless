package school.faang.misseddays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> studentsList = new ArrayList<>();

        addStudent(studentsList, "Mark", "Lawyer", 5000);
        addStudent(studentsList, "Alex", "Programming", 2000);
        addStudent(studentsList, "Bob", "Programming", 2001);
        addStudent(studentsList, "John", "Programming", 2000);
        addStudent(studentsList, "John", "Journalism", 2000);
        addStudent(studentsList, "Jane", "Math", 2000);
        addStudent(studentsList, "Jack", "Programming", 2000);

        deleteStudent(studentsList, "John", "Programming", 2000);

        searchStudentsByFacultyAndYear(studentsList, "Programming", 2000);

        Map<FacultyAndYear, List<Student>> filteredByFacultyAndYear = filterStudents(studentsList);

        printAllStudents(filteredByFacultyAndYear);
    }

    public static Map<FacultyAndYear, List<Student>> filterStudents(List<Student> students) {
        Map<FacultyAndYear, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            FacultyAndYear key = new FacultyAndYear(student.getFaculty(), student.getYear());
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(student);
        }
        return map;
    }

    public static void addStudent(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void deleteStudent(List<Student> students, String name, String faculty, int year) {
        List<Student> toRemove = new ArrayList<>();

        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year &&
                    student.getName().equals(name)) {
                toRemove.add(student);
            }
        }

        students.removeAll(toRemove);
    }

    public static void searchStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                System.out.println(student);
            }
        }
    }

    public static void printAllStudents(Map<FacultyAndYear, List<Student>> filter) {
        for (Map.Entry<FacultyAndYear, List<Student>> entry : filter.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
