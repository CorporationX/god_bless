package tasks.bjs2_32536;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Map<String, Integer>, List<Student>> studentsFlows = new HashMap<>();

    public static void main(String[] args) {
        generateStudents();
        showStudentByFlow("Математический факультет", 3);
        addStudent("", "Математический факультет", 3);
        addStudent("Ольга", "  ", 3);
        addStudent("Ольга", "Математический факультет", -1);
        addStudent("Ольга", "Математический факультет", 3);
        addStudent("Андрей", "Математический факультет", 3);
        addStudent("Андрей", "Математический факультет", 3);
        showStudentByFlow("Математический факультет", 3);
        removeStudent("Иван", "Фантастический факультет", 3);
        removeStudent("Иван", "Математический факультет", 3);
        removeStudent("Иван", "Математический факультет", 3);
        removeStudent("Максим", "Математический факультет", 3);
        removeStudent("Максим", "Математический факультет", 3);
        removeStudent("Максим", "Математический факультет", 3);
        showStudentByFlow("Математический факультет", 3);
    }

    private static void generateStudents() {
        addStudent("Александр", "Физический факультет", 2);
        addStudent("Дмитрий", "Физический факультет", 2);
        addStudent("Николай", "Физический факультет", 2);
        addStudent("Мария", "Химический факультет", 1);
        addStudent("Ольга", "Химический факультет", 1);
        addStudent("Иван", "Математический факультет", 3);
        addStudent("Павел", "Математический факультет", 3);
        addStudent("Максим", "Математический факультет", 3);
        addStudent("Максим", "Математический факультет", 3);
        addStudent("Владимир", "Математический факультет", 3);
        addStudent("Андрей", "Юридический факультет", 2);
        addStudent("Светлана", "Юридический факультет", 2);
        addStudent("Юлия", "Информационные технологии", 3);
        addStudent("Елена", "Информационные технологии", 3);
    }

    private static void addStudent(String name, String faculty, int year) {
        System.out.println(String.format("Добавление студента %s, из потока %d факультета %s", name, year, faculty));

        try {
            Student student = new Student(name, faculty, year);

            studentsFlows.computeIfAbsent(
                Map.of(student.getFaculty(), student.getYear()), k -> new ArrayList<>()
            ).add(student);
            System.out.println("Студент добавлен");

        } catch (Exception e) {
            System.out.println("Невозможно добавить студента по причине : " + e.getMessage());
        }

        System.out.println();
    }

    private static void removeStudent(String name, String faculty, int year) {
        System.out.println(String.format("Удаляем студента %s, из потока %d факультета %s", name, year, faculty));

        try {
            List<Student> students = getStudentByFlow(faculty, year);

            if (students == null) {
                throw new IllegalArgumentException("На данном потоке нет студентов");
            }

            students.remove(
                students.stream()
                    .filter(student -> student.getName().equals(name))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Студента " + name + " нету на потоке"))
            );
            System.out.println("Студент удалён");
        } catch (Exception e) {
            System.out.println("Невозможно удалить студента по причине : " + e.getMessage());
        }

        System.out.println();
    }

    private static List<Student> getStudentByFlow(String faculty, int year) {
        return studentsFlows.get(Map.of(faculty, year));
    }

    private static void showStudentByFlow(String faculty, int year) {
        System.out.println(String.format("Факультет : %s | год обучения : %d", faculty, year));
        getStudentByFlow(faculty, year).forEach(System.out::println);
        System.out.println();
    }
}
