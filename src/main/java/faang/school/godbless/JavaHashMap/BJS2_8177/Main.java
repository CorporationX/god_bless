package faang.school.godbless.JavaHashMap.BJS2_8177;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Dima", "Proger", 1));
        students.add(new Student("Sanya", "Engineering", 2));
        students.add(new Student("Vika", "Proger", 1));
        students.add(new Student("Boba", "Mathematics", 3));
        students.add(new Student("Biba", "Engineering", 2));

        System.out.println();
        printGroupedStudents(groupStudentsByFacultyAndYear(students));

        addStudent(students, new Student("Koko", "Proger", 2));

        System.out.println();
        printGroupedStudents(groupStudentsByFacultyAndYear(students));

        removeStudent(students, "Dima", "Proger", 1);

        System.out.println();
        printGroupedStudents(groupStudentsByFacultyAndYear(students));

        System.out.println();
        findStudentsByFacultyAndYear(students, "Engineering", 2);
    }

    public static Map<String, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + "-" + student.getYear();
            if (!groupedStudents.containsKey(key)) {
                groupedStudents.put(key, new ArrayList<>());
            }
            groupedStudents.get(key).add(student);
        }
        return groupedStudents;
    }

    public static void addStudent(List<Student> students, Student newStudent) {
        students.add(newStudent);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals(name) &&
                    student.getFaculty().equals(faculty) &&
                    student.getYear() == year) {
                students.remove(i);
                break;
            }
        }
    }

    public static void findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                System.out.println(student);
            }
        }
    }

    public static void printGroupedStudents(Map<String, List<Student>> groupedStudents) {
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("Группа: " + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("\t" + student);
            }
        }
    }
}

@AllArgsConstructor
@Data
class Student {
    private String name;
    private String faculty;
    private int year;
}
