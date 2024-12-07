package school.faang.doublecachecache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        Map<Subject, Integer> grades2 = new HashMap<>();
        Student student2 = new Student(2, "Max");
        Subject  subject1 = new Subject(1, "Математика");
        grades2.put(subject1, 3);
        database.addStudent(student2, grades2);

        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(subject1, 5);
        Subject subject2 = new Subject(2, "Физика");
        grades1.put(subject2, 4);
        Student student1 = new Student(1, "Misha");
        database.addStudent(student1, grades1);
        System.out.println("Список всех студентов и их оценки: ");
        database.printAllStudents();
        database.addSubjectForStudent(student1, subject2, 5);
        System.out.println("\nОбновленный список студентов и их оценки: ");
        database.printAllStudents();
    }
}

