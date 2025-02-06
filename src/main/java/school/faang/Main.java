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

        Subject astronomia = new Subject("Астрономия");
        Subject mathematic = new Subject("Математика");

        manageDatabase.addStudent(vasya,astronomia,4);
        manageDatabase.addStudent(petr,mathematic,2);
        manageDatabase.addStudent(eugen,astronomia,3);
        manageDatabase.addStudent(alisa,mathematic,5);

        System.out.println(manageDatabase.getStudentSubjects());
        System.out.println();
        System.out.println(manageDatabase.getSubjectStudents());
    }
}