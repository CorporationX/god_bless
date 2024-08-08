package faang.school.godbless.java.sql.absents;

import faang.school.godbless.java.sql.library.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "IT", 1));
        students.add(new Student("Lisa", "IT", 1));
        students.add(new Student("Daniel", "IT", 4));
        students.add(new Student("Michael", "Biology", 2));
        students.add(new Student("Tanja", "Biology", 2));
        students.add(new Student("Katja", "Math", 3));
        students.add(new Student("Pavel", "Math", 3));
        students.add(new Student("Vasilii", "Math", 3));

        addNewStudentToList(students, "Ivan", "IT", 4);
        removeStudentFromList(students, "Ivan1", "IT", 4);
        removeStudentFromList(students, "Ivan", "IT", 4);

        Map<String, List<Student>> university = sortStudentsByFacultyAndYear(students);
        List<Student> facultyYear = studentsInFacultyAndYear(university, "Math", 3);
        System.out.println(facultyYear);
        showAllStudents(university);
    }

    public static Map<String, List<Student>> sortStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> university = new HashMap<>();
        for (Student student: students) {
            university.computeIfAbsent(
                    String.format("%s_%d", student.getFaculty(), student.getYear()),
                    k -> new ArrayList<>()
                    ).add(student);
        }
        return university;
    }

    public static void addNewStudentToList(List<Student> students, String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudentFromList(List<Student> students, String name, String faculty, int year) {
        if (!students.remove(new Student(name, faculty, year))) {
            System.out.printf("The following student: \"%s, %s, %d\" already absent in the list%n", name, faculty, year);
        }
    }

    public static List<Student> studentsInFacultyAndYear(Map<String, List<Student>>university, String faculty, int year) {
        return university.get(String.format("%s_%d", faculty, year));
    }

    public static void showAllStudents(Map<String, List<Student>> university) {
        for (Map.Entry<String, List<Student>> entry : university.entrySet()) {
            String[] facultyYearArray = entry.getKey().split("_");
            System.out.printf("%nStudents from faculty \"%s\" and year \"%s\":%n", facultyYearArray[0], facultyYearArray[1]);
            for (Student student: entry.getValue()) {
                System.out.printf("\"%s, %s, %d\"%n", student.getName(), student.getFaculty(), student.getYear());
            }
        }
    }
}
