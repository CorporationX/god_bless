package faang.school.godbless.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
    private final static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Добавление студентов в список
        addStudent(new Student("Alice", "Computer Science", 1));
        addStudent(new Student("Bob", "Computer Science", 2));
        addStudent(new Student("Charlie", "Mathematics", 1));
        addStudent(new Student("Dave", "Computer Science", 1));
        addStudent(new Student("Eve", "Mathematics", 2));

        // Группировка студентов по факультетам и курсам
        Map<String, Map<Integer, List<Student>>> groupedStudents = groupStudents(students);

        // Вывод всех студентов, сгруппированных по факультетам и курсам
        printGroupedStudents(groupedStudents);

        // Поиск студентов определенного факультета и курса
        System.out.println("Students from Computer Science, Year 1:");
        List<Student> csYear1Students = findStudents(groupedStudents, "Computer Science", 1);
        for (Student student : csYear1Students) {
            System.out.println(student);
        }

        // Удаление студента
        removeStudent(new Student("Alice", "Computer Science", 1));
        System.out.println("After removing Alice:");
        printGroupedStudents(groupedStudents);
    }

    // Метод для добавления студента в список
    public static void addStudent(Student student) {
        students.add(student);
    }

    // Метод для удаления студента из списка по имени, факультету и курсу
    public static void removeStudent(Student student) {
        students.removeIf(s -> s.getName().equals(student.getName())
                && s.getFaculty().equals(student.getFaculty())
                && s.getYear() == student.getYear());
    }

    // Метод для группировки студентов по факультетам и курсам
    public static Map<String, Map<Integer, List<Student>>> groupStudents(List<Student> students) {
        Map<String, Map<Integer, List<Student>>> map = new HashMap<>();
        for (Student student : students) {
            map.computeIfAbsent(student.getFaculty(), k -> new HashMap<>())
                    .computeIfAbsent(student.getYear(), k -> new ArrayList<>())
                    .add(student);
        }
        return map;
    }

    // Метод для поиска студентов определенного факультета и курса
    public static List<Student> findStudents(Map<String, Map<Integer, List<Student>>> groupedStudents, String faculty, int year) {
        return groupedStudents.getOrDefault(faculty, new HashMap<>()).getOrDefault(year, new ArrayList<>());
    }

    // Метод для вывода всех студентов, сгруппированных по факультетам и курсам
    public static void printGroupedStudents(Map<String, Map<Integer, List<Student>>> groupedStudents) {
        for (Entry<String, Map<Integer, List<Student>>> facultyEntry : groupedStudents.entrySet()) {
            String faculty = facultyEntry.getKey();
            Map<Integer, List<Student>> yearMap = facultyEntry.getValue();
            for (Entry<Integer, List<Student>> yearEntry : yearMap.entrySet()) {
                int year = yearEntry.getKey();
                List<Student> studentList = yearEntry.getValue();
                System.out.println("Faculty: " + faculty + ", Year: " + year);
                for (Student student : studentList) {
                    System.out.println(" - " + student);
                }
            }
        }
    }
}
