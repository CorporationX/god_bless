package school.main;

import school.student_subject.Student;
import school.student_subject.StudentDatabase;
import school.student_subject.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Student student1 = new Student("Иван Иванов");
        final Student student2 = new Student("Петр Петров");
        final Student student3 = new Student("Мария Сидорова");

        final Subject math = new Subject("Математика");
        final Subject physics = new Subject("Физика");
        final Subject chemistry = new Subject("Химия");
        final Subject literature = new Subject("Литература");

        final StudentDatabase db = new StudentDatabase();

        System.out.println("=== Тест 1: Добавление студентов с предметами и оценками ===");

        Map<Subject, Integer> subjects1 = new HashMap<>();
        subjects1.put(math, 5);
        subjects1.put(physics, 4);

        Map<Subject, Integer> subjects2 = new HashMap<>();
        subjects2.put(math, 3);
        subjects2.put(chemistry, 5);

        db.addStudentsWithSubjectsAndMarks(student1, subjects1);
        db.addStudentsWithSubjectsAndMarks(student2, subjects2);
        db.printAllStudents();
        db.printSubjectsAndLearningStudents();

        System.out.println("\n=== Тест 2: Добавление нового предмета для существующего студента ===");
        db.addNewSubjectForStudentWithMark(student1, literature, 4);
        db.printAllStudents();

        System.out.println("\n=== Тест 3: Добавление предмета для группы студентов ===");
        db.addNewSubjectForStudents(literature, List.of(student2, student3));
        db.printAllStudents();
        db.printSubjectsAndLearningStudents();

        System.out.println("\n=== Тест 4: Удаление студента из предмета ===");
        db.removeStudentFromSubjects(student1, physics);
        db.printAllStudents();

        System.out.println("\n=== Тест 5: Удаление студента и его предметов ===");
        db.removeStudentAndHisSubjects(student2);
        db.printAllStudents();
        db.printSubjectsAndLearningStudents();
    }
}
