package faang.school.godbless.countingabsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {

    public static final List<Student> STUDENTS = new ArrayList<>();

    public static void main(String[] args) {
        addStudent("Павел", "Математика", 1);
        addStudent("Владимир", "Математика", 1);
        addStudent("Даниил", "Математика", 1);
        addStudent("Виктор", "Физика", 3);
        addStudent("Петр", "Физика", 3);
        addStudent("Максим", "Химия", 2);
        removeStudent("Максим", "Химия", 2);

        findStudentsByFacultyAndYear("Физика", 3);
        System.out.println();
        showGroupedStudentsByFacultyAndYear(groupStudentsByFacultyAndYear(STUDENTS));
    }

    public static void addStudent(String name, String faculty, int year) {
        STUDENTS.add(new Student(name, faculty, year));
    }

    public static void removeStudent(String name, String faculty, int year) {
        STUDENTS.remove(new Student(name, faculty, year));
    }

    public static void findStudentsByFacultyAndYear(String faculty, int year) {
        STUDENTS.stream()
                .filter(student -> Objects.equals(student.faculty(), faculty)
                        && student.year() == year)
                .forEach(System.out::println);
    }

    public static Map<Map.Entry<String, Integer>, List<Student>>
    groupStudentsByFacultyAndYear(List<Student> students) {
        Map<Map.Entry<String, Integer>, List<Student>> groupedStudentsMap = new HashMap<>();
        for (Student student : students) {
            Map.Entry<String, Integer> key = Map.entry(student.faculty(), student.year());
            if (!groupedStudentsMap.containsKey(key)) {
                groupedStudentsMap.put(key, new ArrayList<>());
            }
            groupedStudentsMap.get(key).add(student);
        }
        return groupedStudentsMap;
    }

    public static void showGroupedStudentsByFacultyAndYear(Map<Map.Entry<String, Integer>, List<Student>> groupedStudentsMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> key : groupedStudentsMap.keySet()) {
            sb.append("(Факультет: ")
                    .append(key.getKey())
                    .append(", ")
                    .append("Курс: ")
                    .append(key.getValue())
                    .append("): ")
                    .append(groupedStudentsMap.get(key))
                    .append("\n");
        }
        System.out.println(sb);
    }
}