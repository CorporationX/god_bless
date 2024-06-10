package faang.school.godbless.task_008;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student("Serg", "Biology", "3"));
        students.add(new Student("Mary", "Biology", "3"));
        students.add(new Student("Kate", "Biology", "1"));
        students.add(new Student("Ivan", "Biology", "2"));
        students.add(new Student("Vlad", "Math", "1"));
        students.add(new Student("Olga", "Math", "2"));
        students.add(new Student("Inna", "Math", "2"));
        students.add(new Student("Vasya", "English", "1"));
        students.add(new Student("Vova", "English", "3"));

        System.out.println("Список студентов:");
        printAllStudents();

        System.out.println();
        System.out.println("Добавление нового студента \"Ira\"");
        String name = "Ira";
        String faculity = "English";
        String year = "2";
        addStudent(name, faculity, year);

        System.out.println();
        System.out.println("Группировка студентов и вывод в консоль");
        Map<List<String>, List<Student>> groupStudents =
                groupStudentsByFacultyAndYear(students);
        printGroupStudents(groupStudents);

        System.out.println("Получение списка студентов " +
                "определённого курса и факультета:");
        faculity = "Math";
        year = "2";
        List<Student> resultSearch = findStudentsByFacultyAndYear(students, faculity, year);
        resultSearch.forEach(System.out::println);

        System.out.println();
        System.out.println("Удаление студента \"Vova\"");
        name = "Vova";
        faculity = "English";
        year = "3";
        deleteStudent(name, faculity, year);

        System.out.println();
        System.out.println("Финальный писок студентов:");
        printAllStudents();

    }

    /*
    ищет студентов определённого факультета и курса.
     */
    private static List<Student> findStudentsByFacultyAndYear(
            List<Student> students, String faculity, String year) {
        return students.stream().filter(s -> s.faculty().equals(faculity)
                && s.year().equals(year)).toList();
    }

    /*
    Выводит Map'у с сгруппированными студентами.
     */
    private static void printGroupStudents(Map<List<String>, List<Student>> groupStudents) {
        for (var entry : groupStudents.entrySet()) {
            List<String> group = entry.getKey();
            System.out.printf("Группа. Факультет: %s, Курс: %s\n", group.get(0), group.get(1));
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }

    /*
    Группирует студентов по факультету и курсу.
     */
    private static Map<List<String>, List<Student>> groupStudentsByFacultyAndYear(List<Student> students) {
        Map<List<String>, List<Student>> result = new HashMap<>();

        for (Student student : students) {
            String faculty = student.faculty();
            String year = student.year();
            List<String> group = List.of(faculty, year);

            if (!result.containsKey(group)) {
                result.put(group, new ArrayList<>(List.of(student)));
            } else {
                result.get(group).add(student);
            }
        }

        return result;
    }

    /*
    Удаляет студента по имени, факультету и курсу.
     */
    private static void deleteStudent(String name, String faculity, String year) {
        students.remove(new Student(name, faculity, year));
    }

    /*
    Выводи список студентов
     */
    private static void printAllStudents() {
        students.forEach(System.out::println);
    }

    /*
    Принимает данные для создание студента и добавления его в список.
     */
    private static void addStudent(String name, String faculity, String year) {
        students.add(new Student(name, faculity, year));
    }
}
