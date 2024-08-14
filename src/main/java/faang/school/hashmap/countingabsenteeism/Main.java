package faang.school.hashmap.countingabsenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

    private static final Set<Student> students = new HashSet<>();
    private static final Map<List<String>, List<String>> studentsByFacultyAndYear = new HashMap<>();

    public static void main(String[] args) {
        Student alex = new Student("Alex", "Biographical", 2);
        Student oleg = new Student("Oleg", "Сhemical", 1);
        Student ivan = new Student("Ivan", "Сhemical", 1);
        Student max = new Student("Max", "Physical", 2);
        Student anna = new Student("Anna", "Physical", 2);

        addNewStudent(alex);
        addNewStudent(oleg);
        addNewStudent(ivan);
        addNewStudent(max);
        addNewStudent(anna);

        for (Map.Entry<List<String>, List<String>> student : groupStudentsByYearAndFaculty(students).entrySet()) {
            System.out.println(student);
        }

        deleteStudent(null);

        try {
            printAllStudentFacultyEndYear("Сhemical", 1);
            printAllStudentFacultyEndYear("Сhemical", 0);
            printAllStudentFacultyEndYear(null, 1);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }

        for (Student studentSet : students) {
            System.out.println(studentSet);
        }
    }

    private static Map<List<String>, List<String>> groupStudentsByYearAndFaculty(Set<Student> studentSet) {
        if (studentSet != null) {
            for (Student student : studentSet) {
                List<String> key = new ArrayList<>();
                key.add(student.getFaculty());
                key.add(String.valueOf(student.getYear()));
                studentsByFacultyAndYear.computeIfAbsent(key, k -> new LinkedList<>()).add(student.getName());
            }
        }
        return studentsByFacultyAndYear;
    }

    private static void addNewStudent(Student student) {
        if (student != null) {
            students.add(student);
        }
    }

    private static void deleteStudent(Student student) {
        students.remove(student);
    }

    private static void printAllStudentFacultyEndYear(String faculty, int year) {
        if (faculty == null
                || faculty.isBlank()
                || year == 0) {
            throw new IllegalArgumentException("Неверные данные");
        } else {
            for (Student student : students) {
                if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                    System.out.println(student);
                }
            }
        }
    }
}
