package school.faang.countingabsent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем список студентов
        List<Student> students = new ArrayList<>();

        // Добавляем студентов в список
        UniversityService universityService = new UniversityService();
        universityService.addStudent(students, new Student("Alice", "Computer Science", 1));
        universityService.addStudent(students, new Student("Bob", "Computer Science", 2));
        universityService.addStudent(students, new Student("Charlie", "Mathematics", 1));
        universityService.addStudent(students, new Student("Dave", "Physics", 3));
        universityService.addStudent(students, new Student("Eve", "Computer Science", 1));

        // Группируем студентов по факультетам и курсам
        Map<String, List<Student>> groupedStudents = universityService.groupStudentsByFacultyAndYear(students);
        universityService.printGroupedStudents(groupedStudents);

        // Поиск студентов по факультету и курсу
        System.out.println("\nStudents in Computer Science, Year 1:");
        List<Student> csYear1 = universityService.findStudentsByFacultyAndYear(students, "Computer Science", 1);
        csYear1.forEach(System.out::println);

        // Удаление студента
        boolean removed = universityService.removeStudent(students, "Alice", "Computer Science", 1);
        System.out.println("\nAlice removed: " + removed);

        // Повторный вывод списка всех студентов после удаления
        groupedStudents = universityService.groupStudentsByFacultyAndYear(students);
        System.out.println("\nUpdated student list:");
        universityService.printGroupedStudents(groupedStudents);
    }
}

