package faang.school.godbless.counting_absenteeism;

import lombok.Data;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Вася", "Факультет1", 2));
        students.add(new Student("Петя", "Факультет2", 1));
        students.add(new Student("Сеня", "Факультет1", 2));
        students.add(new Student("Коля", "Факультет2", 1));

        removeStudent(students, "Коля", "Факультет2", 1);
        infoGroupedStudents(sortStudents(students));
        System.out.println(searchAllStudentsGroup(students, "Факультет2", 1));
    }

    public static Map<Map.Entry<String, Integer>, List<Student>> sortStudents(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> classmates = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> key = new AbstractMap.SimpleEntry<>(student.getFaculty(), student.getYear());
            classmates.putIfAbsent(key, new ArrayList<>());
            classmates.get(key).add(student);
        }
        return classmates;
    }
    public static void removeStudent(List<Student> students, String name, String faculty, int year) {

        for (Student student : students) {
            if (student.getYear() == year && student.getName().equals(name) && student.getFaculty().equals(faculty)) {
                students.remove(student);
                break;
            }
        }
    }

    public static List<Student> searchAllStudentsGroup(List<Student> students, String faculty, int year) {
        List<Student> allStudentsGroup = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                allStudentsGroup.add(student);
            }
        }
        return allStudentsGroup;
    }

    public static void infoGroupedStudents(Map<Map.Entry<String, Integer>, List<Student>> groupedStudents) {
        for (Map.Entry<Map.Entry<String, Integer>, List<Student>> entry : groupedStudents.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }
}


