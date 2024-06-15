package faang.school.godbless.domain.task_absenteeism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("Bob", "Music", 1);
        addStudent("Jon", "Math", 2);
        addStudent("Jack", "Phis", 4);
        addStudent("Neo", "Informatic", 3);
        addStudent("Liza", "Informatic", 3);
        System.out.println(groupStudent(students));
        removeStudent("Bob", "Music", 1);
        System.out.println(students);
        System.out.println(getStudent("Math", 2));
        Map<String, List<Student>> groupedStudents = groupStudent(students);
        printAll(groupedStudents);


    }


    public static Map<String, List<Student>> groupStudent(List<Student> students) {
        Map<String, List<Student>> groupMap = new HashMap<>();
        for (Student student : students) {
            String key = student.faculty() + student.year();
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList<>());
            }
            groupMap.get(key).add(student);
        }
        return groupMap;
    }

    public static void addStudent(String name, String faculty, Integer year) {
        students.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, Integer year) {
        students.remove(new Student(name, faculty, year));
    }

    public static List<Student> getStudent(String faculty, Integer year) {
        List<Student> studentList = new ArrayList<>();
        for (Student student : students) {
            if (student.faculty().equals(faculty) || student.year() == year) {
                studentList.add(student);
            }
        }
        return studentList;

    }

    public static void printAll(Map<String, List<Student>> students) {
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            System.out.println("Факультет и курс: " + entry.getKey() + "; студенты-" + entry.getValue());
        }
    }
}
