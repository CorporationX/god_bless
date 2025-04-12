package school.faang.studentdatabase.main;

import school.faang.studentdatabase.entity.Student;
import school.faang.studentdatabase.entity.Subject;
import school.faang.studentdatabase.service.StudentDatabase;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        StudentDatabase db = new StudentDatabase(new HashMap<>(), new HashMap<>());

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        Subject math = new Subject("Math");
        Subject history = new Subject("History");

        db.addStudentAndSubjects(alice, math, 5);
        db.addStudentAndSubjects(bob, math, 4);
        db.addStudentAndSubjects(alice, history, 3);
        db.addStudentAndSubjects(charlie, history, 4);

        System.out.println(" Студенты и оценки:");
        System.out.println(db.printAllStudentsAndGrades());

        System.out.println(" Предметы и студенты:");
        System.out.println(db.printAllSubjectsAndStudents());

        db.removeStudentFromSubject(history, alice);
        System.out.println("\n После удаления Alice из History:");
        System.out.println(db.printAllStudentsAndGrades());
        System.out.println(db.printAllSubjectsAndStudents());
    }
}

/* Требования:
6️⃣ Дополнительно:
Реализуйте юнит-тесты для проверки корректности работы методов.  */