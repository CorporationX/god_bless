package school.faang.bjs2_86056;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        final StudentDatabase database = new StudentDatabase();

        final Student student1 = new Student("Сидоров Сергей ");
        final Student student2 = new Student("Петрова Анна ");
        final Student student3 = new Student("Иванова Света ");
        final Student student4 = new Student("Козлов Дмитрий ");

        final Subject math = new Subject("Математика");
        final Subject physics = new Subject("Физика");
        final Subject chemistry = new Subject("Химия");
        final Subject history = new Subject("История");

        System.out.println("=== ТЕСТ 1: Добавление студентов с оценками ===");
        final Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(math, 5);
        grades1.put(physics, 4);
        database.addStudentWithGrades(student1, grades1);

        final Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(math, 3);
        grades2.put(chemistry, 5);
        database.addStudentWithGrades(student2, grades2);

        System.out.println("Студенты добавлены с оценками");

        System.out.println("\n=== ТЕСТ 2: Добавление предмета для студента ===");
        database.addSubjectForStudent(student3, history, 4);
        System.out.println("Добавлен предмет История для студента " + student3.getName() + " с оценкой 4");

        System.out.println("\n=== ТЕСТ 3: Добавление предмета со студентами ===");
        final List<Student> historyStudents = Arrays.asList(student1, student2, student4);
        database.addSubjectWithStudents(history, historyStudents);
        System.out.println("Добавлен предмет История со студентами");

        System.out.println("\n=== ТЕСТ 4: Удаление студента из предмета ===");
        database.removeStudentFromSubject(student1, history);
        System.out.println("Студент " + student1.getName() + " удален из предмета История");

        System.out.println("\n=== ТЕСТ 5: Получение студентов по предмету ===");
        final List<Student> mathStudents = database.getStudentsForSubject(math);
        System.out.println("Студенты, изучающие Математику:");
        for (final Student student : mathStudents) {
            System.out.println("- " + student.getName());
        }

        System.out.println("\n=== ТЕСТ 6: Получение оценки ===");
        final Integer grade = database.getGrade(student1, math);
        System.out.println(student1.getName() + " по Математике: " + grade);

        System.out.println("\n=== ТЕСТ 7: Удаление студента полностью ===");
        database.removeStudent(student2);
        System.out.println("Студент " + student2.getName() + " полностью удален из базы");
    }
}