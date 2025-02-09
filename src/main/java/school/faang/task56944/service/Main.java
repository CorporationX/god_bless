package school.faang.task56944.service;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StudentDatabase manageDatabase = new StudentDatabase();

        Student vasya = new Student("Василий");
        Student petr = new Student("Петр");
        Student eugen = new Student("Евгений");
        Student alisa = new Student("Алиса");
        Student fantom = new Student("Фантом");

        Subject astronomia = new Subject("Астрономия");
        Subject mathematic = new Subject("Математика");
        Subject fizika = new Subject("Физика");

        System.out.println("Добавление студентов с предметами и оценками:");
        manageDatabase.addStudent(vasya, astronomia, 4);
        manageDatabase.addStudent(petr, mathematic, 2);
        manageDatabase.addStudent(eugen, astronomia, 3);
        manageDatabase.addStudent(alisa, mathematic, 5);

        System.out.println("\nДобавление предмета существующему студенту:");
        manageDatabase.addSubjectToStudent(eugen, fizika, 5);

        System.out.println("\nПопытка добавить предмет несуществующему студенту:");
        try {
            manageDatabase.addSubjectToStudent(fantom, mathematic, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nДобавление нового предмета со списком студентов:");
        Subject chemistry = new Subject("Химия");
        manageDatabase.addSubject(chemistry, Arrays.asList(vasya, petr, alisa));

        System.out.println("\nДобавление студента к существующему предмету:");
        manageDatabase.addStudentToSubject(chemistry, eugen);

        System.out.println("\nУдаление студента из предмета:");
        manageDatabase.removeStudentFromSubject(mathematic, petr);

        System.out.println("\nУдаление студента:");
        manageDatabase.removeStudent(alisa);

        System.out.println("\nВывод списка всех студентов и их оценок по предметам:");
        manageDatabase.printAllStudentsAndGrades();

        System.out.println("\nВывод списка всех предметов и студентов, изучающих их:");
        manageDatabase.printAllSubjectsAndStudents();
    }
}