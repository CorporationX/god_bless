package school.faang.cache;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        System.out.println("Добавление нового студента и его предметов с оценками");
        studentDatabase.addStudentWithGrade("Iya Lobach", List.of(new GradedItem("Math", 5),
                new GradedItem("Сomputer science", 5)));
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Добавление нового предмета для существующего студента с оценкой");
        studentDatabase.addStudentWithGrade("Iya Lobach", List.of(new GradedItem("History", 3)));
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Добавление нового студента и его предметов с оценками");
        studentDatabase.addStudentWithGrade("NotIya NotLobach", List.of(new GradedItem("History", 5)));
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Добавление нового предмета и списка студентов, изучающих его");
        studentDatabase.addSubjectWithStudents("Probability theory", List.of("Iya Lobach"));
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Добавление студента к существующему предмету");
        studentDatabase.addSubjectWithStudents("Probability theory", List.of("NotIya NotLobach"));
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Удаление студента и его предметов");
        studentDatabase.deleteStudentByName("NotIya NotLobach");
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");

        System.out.println("Удаление студента из предмета");
        studentDatabase.deleteStudentFromSubject("Iya Lobach", "Probability theory");
        studentDatabase.printStudentWithGrade();
        studentDatabase.printSubjectWithStudents();
        System.out.println("-----------------------");
    }
}
