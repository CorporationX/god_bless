package school.faang;

import school.faang.service.Student;
import school.faang.service.StudentDatabase;
import school.faang.service.Subject;

public class Main {
    public static void main(String[] args) {
        StudentDatabase manageDatabase = new StudentDatabase();
        Student vasya = new Student("Василий");
        Student petr = new Student("Петр");
        Student eugen = new Student("Евгений");
        Student alisa = new Student("Алиса");
        Student fantom = new Student("Студент который не ходит на занятия (тест)");

        Subject astronomia = new Subject("Астрономия");
        Subject mathematic = new Subject("Математика");
        Subject fizika = new Subject("Физика");

        manageDatabase.addStudent(vasya, astronomia, 4);
        manageDatabase.addStudent(petr, mathematic, 2);
        manageDatabase.addStudent(eugen, astronomia, 3);
        manageDatabase.addStudent(alisa, mathematic, 5);

        manageDatabase.addSubject(eugen, fizika, 5);
        manageDatabase.addSubject(fantom, mathematic, 5);

        manageDatabase.removeStudentSubject(vasya, astronomia);
        manageDatabase.prinAllInfo();
    }
}