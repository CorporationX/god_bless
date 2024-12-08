package school.faang.task_45202;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
        Map<Subject, List<Student>> studentBySubject = new HashMap<>();

        StudentDatabase studentDatabase = new StudentDatabase();

        final Subject math = new Subject("Math");
        final Subject physics = new Subject("Physics");
        final Subject russian = new Subject("Russian");
        final Student vasya = new Student("Vasya");
        final Student petya = new Student("Petya");
        final Student alina = new Student("Alina");

        Map<Subject, Integer> vasyaSubjects = new HashMap<>();
        vasyaSubjects.put(math, 5);
        vasyaSubjects.put(physics, 4);

        studentDatabase.addNewStudentWithGrades(vasya, vasyaSubjects);

        Map<Subject, Integer> petyaSubjects = new HashMap<>();
        petyaSubjects.put(math, 3);
        petyaSubjects.put(russian, 4);
        studentDatabase.addNewStudentWithGrades(petya, petyaSubjects);

        Map<Subject, Integer> alinaSubjects = new HashMap<>();
        alinaSubjects.put(math, 5);
        alinaSubjects.put(physics, 5);
        studentDatabase.addNewStudentWithGrades(alina, alinaSubjects);

        System.out.println("Все студенты с их предметами и оценками:");
        studentDatabase.printAllStudentsFromSubject();

        studentDatabase.addNewSubjectForStudent(vasya, russian, 4);

        System.out.println("\nПосле добавления нового предмета для Васи:");
        studentDatabase.printAllStudentsFromSubject();

        studentDatabase.removeStudent(petya);

        System.out.println("\nПосле удаления Пети:");
        studentDatabase.printAllStudentsFromSubject();

        studentDatabase.addSubjectForStudent(new Subject("Literature"), List.of(vasya, alina));

        System.out.println("\nПосле добавления нового предмета для студентов:");
        studentDatabase.printAllSubjectsForStudent();

        studentDatabase.addStudentToSubject(alina, math);

        System.out.println("\nПосле добавления Алины к предмету Математика:");
        studentDatabase.printAllSubjectsForStudent();

        studentDatabase.removeStudentFromSubject(alina, physics);

        System.out.println("\nПосле удаления Алины из предмета Физика:");
        studentDatabase.printAllSubjectsForStudent();
    }
}
