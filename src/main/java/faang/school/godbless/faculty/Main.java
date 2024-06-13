package faang.school.godbless.faculty;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Lena", "Economy", 1));
        students.add(new Student("Inna", "Economy", 1));
        students.add(new Student("Andrew", "History", 1));
        students.add(new Student("Ben", "History", 3));
        students.add(new Student("David", "IT", 1));
        students.add(new Student("Leo", "IT", 2));

        addStudent("Anna", "IT", 1);
        removeStudent("Ben", "History", 3);
        System.out.println(students);
        System.out.println(findAllStudentsByFacultyAndYear(students, "IT", 1));
        printStudentsListByFacultyAndYear(getStudentsByFacultyAndYear(students));
    }

    public static Map<Map<String, Integer>, List<Student>> getStudentsByFacultyAndYear(List<Student> students) {
        Map<Map<String, Integer>, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            String faculty = student.faculty();
            Integer year = student.year();
            Map<String, Integer> key = Map.of(faculty, year);

            if (result.containsKey(key)) {
                result.get(key).add(student);
            } else {
                result.put(key, new ArrayList<>(List.of(student)));
            }
        }
        return result;
    }

    public static void printStudentsListByFacultyAndYear(Map<Map<String, Integer>, List<Student>> students) {
        students.forEach((key, studentsList) -> {
            key.forEach((faculty, year) -> {
                System.out.println("Faculty: " + faculty + ", Year: " + year);
            });
            studentsList.forEach(student -> {
                System.out.println(" " + student);
            });

        });
    }

    public static void addStudent(String name, String faculty, int year) {
        Student newStudent = new Student(name, faculty, year);
        students.add(newStudent);
    }

    public static void removeStudent(String name, String faculty, int year) {
        Student studentToRemove = new Student(name, faculty, year);
        students.remove(studentToRemove);
    }

    public static Set<Student> findAllStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        return students.stream().
                filter(s -> s.faculty().matches(faculty) && s.year() == year)
                .collect(Collectors.toSet());
    }


}
