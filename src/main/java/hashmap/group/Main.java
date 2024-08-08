package hashmap.group;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Id, List<Student>> studentsMap;
        List<Student> studentsList = new ArrayList<>();
        Map<Student, Integer> studentsListIndex = new HashMap<>();
        Student student1 = new Student("Aboba", "bib", 1);
        Student student2 = new Student("Abiba", "bob", 2);
        Student student3 = new Student("Abuba", "bib", 1);
        studentsList.add(student1);
        studentsList.add(student2);
        studentsList.add(student3);
        fillIndex(studentsList, studentsListIndex);
        studentsMap = fillMap(studentsList);
        printAllStudentsByGroup(studentsMap);
        addStudent(studentsList, studentsMap, studentsListIndex, new Student("Abeba", "bob", 2));
        searchSameFacultyAndYearStudents(studentsMap, "bob", 2);
        searchSameFacultyAndYearStudents(studentsMap, "bob", 3);
        removeStudent(studentsList, studentsMap, studentsListIndex, "Aboba", "bib", 1);
        removeStudent(studentsList, studentsMap, studentsListIndex, "Ababa", "bub", 1);
        printAllStudentsByGroup(studentsMap);
    }

    public static void fillIndex(@NonNull List<Student> studentsList, @NonNull Map<Student, Integer> studentsListIndex) {
        for (int i = 0; i < studentsList.size(); i++) {
            studentsListIndex.put(studentsList.get(i), i);
        }
    }

    public static Map<Id, List<Student>> fillMap(@NonNull List<Student> students) {
        Map<Id, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            Id id = new Id(student.getFaculty(), student.getYear());
            studentsMap.computeIfAbsent(id, k -> new ArrayList<>()).add(student);
        }

        return studentsMap;
    }

    public static void addStudent(
            @NonNull List<Student> studentsList,
            @NonNull Map<Id, List<Student>> studentsMap,
            @NonNull Map<Student, Integer> studentsListIndex,
            @NonNull Student student
    ) {
        if (studentsListIndex.get(student) != null) {
            System.out.println("\nStudent is already added");
        } else {
            studentsList.add(student);
            studentsListIndex.put(student, studentsList.size() - 1);
            Id id = new Id(student.getFaculty(), student.getYear());
            studentsMap.computeIfAbsent(id, k -> new ArrayList<>()).add(student);
            System.out.println("\nNew student added");
        }
    }

    public static void removeStudent(
            @NonNull List<Student> studentsList,
            @NonNull Map<Id, List<Student>> studentsMap,
            @NonNull Map<Student, Integer> studentsListIndex,
            @NonNull String name, @NonNull String faculty, int year
    ) {
        Student student = new Student(name, faculty, year);
        if (studentsListIndex.get(student) != null) {
            studentsList.remove(studentsListIndex.get(student).intValue());
            studentsListIndex.remove(student);
            Id id = new Id(faculty, year);
            List<Student> students = studentsMap.get(id);
            if (students == null) {
                System.out.println("\nThere is no such group in map");
            } else {
                if (students.contains(student)) {
                    students.remove(student);
                    System.out.println("\nStudent removed from list");
                } else {
                    System.out.println("\nThere is no such student in this group");
                }
            }
        } else {
            System.out.println("\nThere is no such student in list");
        }
    }

    public static List<Student> searchSameFacultyAndYearStudents(
            @NonNull Map<Id, List<Student>> studentsMap,
            @NonNull String faculty, int year
    ) {

        Id id = new Id(faculty, year);
        List<Student> studentsList = studentsMap.get(id);
        if (studentsList != null) {
            System.out.println();
            studentsList.forEach(System.out::println);
        } else {
            System.out.println("\nThere is no such group");
        }

        return studentsList;
    }

    public static void printAllStudentsByGroup(@NonNull Map<Id, List<Student>> studentsMap) {
        System.out.println();
        if (studentsMap.isEmpty()) {
            System.out.println("List is empty");
        }
        for (Map.Entry<Id, List<Student>> entry : studentsMap.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + " " + entry.getKey().getYear());
            for (Student student : entry.getValue()) {
                System.out.println("    " + student);
            }
        }
    }
}