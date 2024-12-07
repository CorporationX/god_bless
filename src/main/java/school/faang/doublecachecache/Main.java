package school.faang.doublecachecache;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        Student student1 = new Student(1, "Misha");
        Student student2 = new Student(2, "Max");

        Subject subject1 = new Subject(1, "Математика");
        Subject subject2 = new Subject(2, "Физика");

        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(subject1, 5);
        grades1.put(subject2, 4);
        database.addStudent(student1, grades1);

        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(subject1, 3);
        database.addStudent(student2, grades2);


        System.out.println("Список всех студентов и их оценки: ");
        database.printAllStudents();

        database.addSubjectForStudent(student1, subject2, 5);
        System.out.println("\nОбновленный список студентов и их оценки: ");
        database.printAllStudents();
    }
}

