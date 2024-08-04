package hashmap.group;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<Id, List<Student>> STUDENTS_MAP;
    public static List<Student> STUDENTS_LIST = new ArrayList<>();

    public static void main(String[] args) {
        Student student1 = new Student("Aboba", "bib", 1);
        Student student2 = new Student("Abiba", "bib", 2);
        Student student3 = new Student("Abuba", "bib", 1);
        STUDENTS_LIST.add(student1);
        STUDENTS_LIST.add(student2);
        STUDENTS_LIST.add(student3);
        STUDENTS_MAP = fillMap(STUDENTS_LIST);
        printAllStudentsBuGroup();

    }

    public static Map<Id, List<Student>> fillMap(@NonNull List<Student> students) {
        Map<Id, List<Student>> studentsMap = new HashMap<>();
        for (Student student : students) {
            Id id = new Id(student.getFaculty(), student.getYear());
            studentsMap.computeIfAbsent(id, k -> new ArrayList<>()).add(student);
        }

        return studentsMap;
    }

    public static void addStudent(@NonNull Student student) {
        if (STUDENTS_LIST.contains(student)) {
            System.out.println("Student is already added");
        } else {
            STUDENTS_LIST.add(student);
            Id id = new Id(student.getFaculty(), student.getYear());
            STUDENTS_MAP.computeIfAbsent(id, k -> new ArrayList<>()).add(student);
            System.out.println("New student added");
        }
    }

    public static void removeStudent(@NonNull String name, @NonNull String faculty, int year) {
        Student student = new Student(name, faculty, year);
        if (STUDENTS_LIST.contains(student)) {
            STUDENTS_LIST.remove(student);
            Id id = new Id(faculty, year);
            List<Student> studentList = STUDENTS_MAP.get(id);
            if (studentList == null) {
                System.out.println("There is no such group in map");
            } else {
                if (studentList.contains(student)) {
                    studentList.remove(student);
                } else {
                    System.out.println("There is no such student in this group");
                }
            }
        } else {
            System.out.println("There is no such student in list");
        }
    }

    public static List<Student> searchSameFacultyAndYearStudents(@NonNull String faculty, int year) {
        Id id = new Id(faculty, year);
        List<Student> studentsList = STUDENTS_MAP.get(id);
        if (studentsList != null) {
            System.out.println();
            studentsList.forEach(System.out::println);
        } else {
            System.out.println("There is no such group");
        }

        return studentsList;
    }

    public static void printAllStudentsBuGroup() {
        for (Map.Entry<Id, List<Student>> entry : STUDENTS_MAP.entrySet()) {
            System.out.println(entry.getKey().getFaculty() + " " + entry.getKey().getYear());
            for (Student student : entry.getValue()) {
                System.out.println("    " + student);
            }
        }
    }
}
