package school.faang.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheTesting {

    public static void main(String[] args) {
        Student john = new Student("John");
        Student katy = new Student("Katy");
        Student sara = new Student("Sara");

        Subject math = new Subject("Math");
        Subject eng = new Subject("Eng");
        Subject physic = new Subject("Physic");
        Subject history = new Subject("History");

        Map<Subject, Integer> subjectsForJohn = new HashMap<>(Map.of(
                math, 4,
                physic, 3));

        Map<Subject, Integer> subjectsForKaty = new HashMap<>(Map.of(
                math, 5,
                eng, 4));

        Map<Subject, Integer> subjectsForSara = new HashMap<>(Map.of(
                eng, 5,
                physic, 4));

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithMarks(john, subjectsForJohn);
        studentDatabase.addStudentWithMarks(katy, subjectsForKaty);
        studentDatabase.addStudentWithMarks(sara, subjectsForSara);
        System.out.println("Новые студенты: ");
        studentDatabase.printStudent();

        studentDatabase.addSubjectForStudent(john, history, 5);
        System.out.println("\nДобавлен предмет для Джона: ");
        studentDatabase.printStudent();

        studentDatabase.removeStudent(john);
        System.out.println("\nДжон удален из списка: ");
        studentDatabase.printStudent();

        studentDatabase.addSubject(new Subject("Rus"), new ArrayList<>(List.of(katy, sara)));
        System.out.println("\nДобавлен новый предмет: ");
        studentDatabase.printSubject();

        System.out.println("\nСара добавлена в список студентов, изучающих историю: ");
        studentDatabase.addStudentToSubject(sara, history);
        studentDatabase.printSubject();

        System.out.println("\nСара удалена из изучения физики: ");
        studentDatabase.removeStudentFromSubject(sara, physic);
        studentDatabase.printSubject();
    }
}
