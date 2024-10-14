package school.faang.m1s1.bsj2_32454_abscenceCount;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        studentList.addAll(List.of(
                new Student("Kirk", "Management", 3),
                new Student("Spok", "Physics", 3),
                new Student("Uhura", "IT", 1),
                new Student("Pickard", "Management", 3)
        ));

        System.out.println(studentList);
        System.out.println(sortByFacultyYear(studentList));

        addStudent(new Student("Skywalker", "Dark Force", 15));
        System.out.println(sortByFacultyYear(studentList));

        deleteStudent("Skywalker", "Dark Force", 15);
        System.out.println(sortByFacultyYear(studentList));

        System.out.println(searchStudents("Management", 3));

        displayStudents();
    }

    @Data
    @AllArgsConstructor
    private static class FacultyYearKey {
        private String faculty;
        private int year;
    }

    private static Map<FacultyYearKey, List<Student>> sortByFacultyYear(List<Student> studentList) {
        Map<FacultyYearKey, List<Student>> groupedMap = new HashMap<>();

        for (Student student : studentList) {
            String faculty = student.getFaculty();
            int year = student.getYear();
            FacultyYearKey facultyYearKey = new FacultyYearKey(faculty, year);

            groupedMap.computeIfAbsent(facultyYearKey, key -> new ArrayList<>()).add(student);
        }
        return groupedMap;
    }

    private static void addStudent(Student student) {
        studentList.add(student);
    }

    private static void deleteStudent(String name, String faculty, int year) {
        studentList.remove(new Student(name, faculty, year));
    }

    private static List<Student> searchStudents(String faculty, int year) {
        return sortByFacultyYear(studentList).get(new FacultyYearKey(faculty, year));
    }

    private static void displayStudents() {
        for (Map.Entry<FacultyYearKey, List<Student>> entry : sortByFacultyYear(studentList).entrySet()) {
            String faculty = entry.getKey().getFaculty();
            int year = entry.getKey().getYear();
            List<Student> students = entry.getValue();
            System.out.printf("Faculty: %s; Year: %d; Students: ", faculty, year);
            for (Student student : students) {
                System.out.printf("%s, ", student.getName());
            }
            System.out.println();
        }
    }


}
