package faang.school.godbless.skip_count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Tom", "Chemistry", 3));
        students.add(new Student("Bob", "Alchemy", 1));
        students.add(new Student("Ann", "Biology", 3));
        students.add(new Student("Mark", "Biology", 3));


        Map<String, List<Student>> groupedStudents = groupStudents(students);
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("===================>>>>>>>>>>>>>>>>>>");
        searchStudents(groupedStudents, "Biology", 3);
        searchStudents(groupedStudents, "Astronomy", 2);

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        addStudent(groupedStudents, new Student("Tom", "Chemistry", 3));
        addStudent(groupedStudents, new Student("Mick", "Astronomy", 1));

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        removeStudent(groupedStudents, new Student("Brad", "Astronomy", 4));
        removeStudent(groupedStudents, new Student("Bob", "Alchemy", 1));

        System.out.println("==================>>>>>>>>>>>>>>>>>>>");
        allStudents(groupedStudents);
    }

    private static Map<String, List<Student>> groupStudents(List<Student> students) {
        Map<String, List<Student>> grouped = new HashMap<>();
        for (Student student : students) {
            String key = student.getFaculty() + " / " + student.getYear();
            if (!grouped.containsKey(key)) {
                grouped.put(key, new ArrayList<>());
            }
            grouped.get(key).add(student);
        }
        return grouped;
    }

    private static void addStudent(Map<String, List<Student>> groupedStudents, Student student) {
        String key = student.getFaculty() + " / " + student.getYear();
        List<Student> students = groupedStudents.getOrDefault(key, new ArrayList<>());
        if (!students.contains(student)) {
            students.add(student);
            groupedStudents.put(key, students);
            System.out.println("Студент " + student + " добавлен");
        } else {
            System.out.println("Студент " + student + " уже есть в списке");
        }
    }

    private static void removeStudent(Map<String, List<Student>> groupedStudents, Student student) {
        String key = student.getFaculty() + " / " + student.getYear();
        List<Student> students = groupedStudents.get(key);
        if (students != null && students.contains(student)) {
            students.remove(student);
            if (students.isEmpty()) {
                groupedStudents.remove(key);
            } else {
                groupedStudents.put(key, students);
            }
            System.out.println("Студент " + student + " удалён");
        } else {
            System.out.println("Студента " + student + " нет в списке");
        }
    }

    private static void searchStudents(Map<String, List<Student>> groupedStudents, String faculty, int year) {
        String key = faculty + " / " + year;
        List<Student> students = groupedStudents.get(key);
        if (students != null) {
            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append(student).append("; ");
            }
            System.out.println("На факультете " + faculty + " " + year + " курса учатся: " + sb);
        } else {
            System.out.println("На факультете " + faculty + " " + year + " курса нет студентов");
        }
    }

    private static void allStudents(Map<String, List<Student>> groupedStudents) {
        for (Map.Entry<String, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println("На факультете " + entry.getKey() + " учится:");
            for (Student student : entry.getValue()) {
                System.out.println(student);
            }
            System.out.println();
        }
    }
}
