package faang.school.godbless.countingabsences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Добавление нового студента
        addStudent(students, new Student("Павел", "Математика", 1));
        addStudent(students, new Student("Владимир", "Математика", 1));
        addStudent(students, new Student("Даниил", "Математика", 1));
        addStudent(students, new Student("Виктор", "Физика", 3));
        addStudent(students, new Student("Петр", "Физика", 3));
        addStudent(students, new Student("Максим", "Химия", 2));

        // Удаление студента
        removeStudent(students, "Максим", "Химия", 2);

        // Группировка студентов по факультетам и курсам
        Map<String, Map<Integer, List<Student>>> groupedStudents = groupStudentsByFacultyAndYear(students);

        // Вывод всех студентов, сгруппированных по факультетам и курсам
        printGroupedStudents(groupedStudents);

        // Поиск студентов по факультету и курсу
        List<Student> physicsStudents = findStudentsByFacultyAndYear(students, "Физика", 3);
        System.out.println("Физика, Year 3: " + physicsStudents);
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, String name, String faculty, int year) {
        students.removeIf(student -> student.getName().equals(name)
                && student.getFaculty().equals(faculty)
                && student.getYear() == year);
    }

    public static List<Student> findStudentsByFacultyAndYear(List<Student> students, String faculty, int year) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty().equals(faculty) && student.getYear() == year) {
                result.add(student);
            }
        }
        return result;
    }

    public static Map<String, Map<Integer, List<Student>>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<String, Map<Integer, List<Student>>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            groupedStudents
                    .computeIfAbsent(student.getFaculty(), k -> new HashMap<>())
                    .computeIfAbsent(student.getYear(), k -> new ArrayList<>())
                    .add(student);
        }
        return groupedStudents;
    }

    public static void printGroupedStudents(Map<String, Map<Integer, List<Student>>> groupedStudents) {
        for (String faculty : groupedStudents.keySet()) {
            System.out.println("Faculty: " + faculty);
            Map<Integer, List<Student>> yearGroups = groupedStudents.get(faculty);
            for (Integer year : yearGroups.keySet()) {
                System.out.println("  Year " + year + ": " + yearGroups.get(year));
            }
        }
    }
}