package school.faang.BJS232449;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Map<String, Integer>, List<Student>> LIST_STUDENTS = new HashMap<>();

    static Map<Map<String, Integer>, List<Student>> addStudentsToList(List<Student> students) {
        for (Student student : students) {
            Map<String, Integer> key = Map.of(student.getFaculty(), student.getYear());
            LIST_STUDENTS.computeIfAbsent(key, v -> new ArrayList<>()).add(student);
        }
        return LIST_STUDENTS;
    }

    static void addNewStudent(Student newStudent) {
        Map<String, Integer> key = Map.of(newStudent.getFaculty(), newStudent.getYear());
        LIST_STUDENTS.computeIfAbsent(key, v -> new ArrayList<>()).add(newStudent);
    }

    static void deleteStudentByName(String name, String faculty, int year) {
        for (Map.Entry<Map<String, Integer>, List<Student>> mapListEntry : LIST_STUDENTS.entrySet()) {
            for (Student student : mapListEntry.getValue()) {
                if (student.getName().equals(name) && student.getFaculty().equals(faculty) && student.getYear() == year) {
                    mapListEntry.getValue().remove(student);
                    System.out.println("DELETED - " + student);
                }
            }
        }
    }

    static List<Student> findStudentsByFacultyAndYear(String faculty, int year) {
        Map<String, Integer> key = Map.of(faculty, year);
        return LIST_STUDENTS.get(key);
    }

    static void getAll() {
        for (Map.Entry<Map<String, Integer>, List<Student>> mapListEntry : LIST_STUDENTS.entrySet()) {
            System.out.println(mapListEntry.getKey() + " ");
            for (Student student : mapListEntry.getValue()) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex", "Software Engineering", 1));
        students.add(new Student("John", "Marketing", 2));
        students.add(new Student("Esther", "Finance", 3));
        students.add(new Student("Tiffany", "Software Engineering", 1));
        students.add(new Student("Brook", "Marketing", 2));
        students.add(new Student("James", "Finance", 3));

        System.out.println(addStudentsToList(students));
        addNewStudent(new Student("Batyr", "Jurisprudence", 1));
        deleteStudentByName("Alex", "Software Engineering", 1);
        System.out.println(LIST_STUDENTS);
        System.out.println(findStudentsByFacultyAndYear("Marketing", 2));
        getAll();
    }
}
