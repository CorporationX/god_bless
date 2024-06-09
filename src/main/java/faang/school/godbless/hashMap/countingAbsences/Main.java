package faang.school.godbless.hashMap.countingAbsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        add("name1", "faculty1", 1);
        add("name2", "faculty1", 2);
        add("name3", "faculty1", 3);
        add("name4", "faculty2", 4);
        add("name5", "faculty3", 1);
        add("name6", "faculty2", 2);
        add("name7", "faculty1", 2);
        add("name8", "faculty2", 2);
        add("name9", "faculty3", 1);
        add("name10", "faculty3", 2);
        add("name11", "faculty3", 1);
        add("name12", "faculty3", 1);

        delete("name3", "faculty1", 3);
        printSortedStudents(getSortedStudents(students));

        System.out.println(getStudentsByFacultyAndYear("faculty1", 2));
    }

    public static void add(String name, String faculty, int year) {
        students.add(new Student(name, faculty, year));
    }

    public static void delete(String name, String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (students.contains(student)) {
            students.remove(student);
        } else {
            throw new NotFoundException("Student " + student + " not found");
        }
    }

    public static Map<Map<String, Integer>, List<Student>> getSortedStudents(List<Student> students) {
        if (students == null) {
            throw new IllegalArgumentException("Passed null");
        }

        Map<Map<String, Integer>, List<Student>> sortedStudents = new HashMap<>();
        for (Student student : students) {
            Map<String, Integer> key = Map.of(student.getFaculty(), student.getYear());
            sortedStudents.computeIfAbsent(key, k -> new ArrayList<>()).add(student);
        }
        return sortedStudents;
    }

    public static List<Student> getStudentsByFacultyAndYear(String faculty, int year) {
        if (faculty == null || faculty.isEmpty() || faculty.isBlank()) {
            throw new IllegalArgumentException("Faculty can`t be empty");
        }

        List<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public static void printSortedStudents(Map<Map<String, Integer>, List<Student>> sortedStudents) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Map<String, Integer>, List<Student>> entry : sortedStudents.entrySet()) {
            for (Map.Entry<String, Integer> innerEntry : entry.getKey().entrySet()) {
                sb.append("\nFaculty: ").append(innerEntry.getKey()).append(", year: ").append(innerEntry.getValue());
            }

            sb.append("\nStudents:");
            for (Student student : entry.getValue()) {
                sb.append("\n").append(student);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}