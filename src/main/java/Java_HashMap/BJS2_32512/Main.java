package Java_HashMap.BJS2_32512;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса Service
        Service service = new Service();

        // Создаем студентов
        Student student1 = new Student(1, "Алексей");
        Student student2 = new Student(2, "Мария");

        // Создаем предметы
        Subject subject1 = new Subject(101, "Математика");
        Subject subject2 = new Subject(102, "Физика");

        // Добавляем студентов и их оценки по предметам
        Map<Subject, Integer> gradesForStudent1 = new HashMap<>();
        gradesForStudent1.put(subject1, 5);
        gradesForStudent1.put(subject2, 4);
        service.addStudent(student1, gradesForStudent1);

        Map<Subject, Integer> gradesForStudent2 = new HashMap<>();
        gradesForStudent2.put(subject1, 3);
        service.addStudent(student2, gradesForStudent2);

        // Вывод всех студентов и их оценок
        System.out.println("Список всех студентов и их оценок:");
        service.printAllStudents();

        // Добавляем новый предмет и студента к нему
        service.addSubject(subject2); // Добавляем предмет "Физика"
        service.addStudentToSubject(subject2, student1); // Добавляем Алексея к предмету "Физика"

        // Вывод всех предметов и студентов, изучающих их
        System.out.println("\nСписок всех предметов и студентов, изучающих их:");
        service.printAllSubjects();

        // Удаляем студента
        service.removeStudent(student2);
        System.out.println("\nПосле удаления студента:");
        service.printAllStudents();
    }
}
