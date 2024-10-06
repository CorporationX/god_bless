package school.faang.doublecache;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "Коля");
        Student student2 = new Student(2, "Костя");
        Student student3 = new Student(3, "Андрей");

        Subject subject1 = new Subject(1, "Тервер");
        Subject subject2 = new Subject(2, "Линал");
        Subject subject3 = new Subject(3, "Дискретная математика");
        Subject subject4 = new Subject(4, "Архитектура ПО");

        Map<Subject, Integer> subjectToMark1 = new HashMap<>();
        subjectToMark1.put(subject1, 5);
        subjectToMark1.put(subject2, 4);
        subjectToMark1.put(subject3, 5);

        Map<Subject, Integer> subjectToMark2 = new HashMap<>();
        subjectToMark2.put(subject1, 2);
        subjectToMark2.put(subject2, 1);
        subjectToMark2.put(subject3, 5);

        Map<Subject, Integer> subjectToMark3 = new HashMap<>();
        subjectToMark3.put(subject1, 4);
        subjectToMark3.put(subject2, 4);
        subjectToMark3.put(subject3, 4);


        UniversityDB universityDB = new UniversityDB();

        //Добавление студента
        System.out.println("Добавляем студентов");
        universityDB.addStudent(student1, subjectToMark1);
        universityDB.addStudent(student2, subjectToMark2);
        universityDB.addStudent(student3, subjectToMark3);
        universityDB.printMarksByStudent();
        universityDB.printStudentsBySubject();
        System.out.println();

        //Добавление нового предмета и списка студентов
        Map<Student, Integer> studentToMark1 = new HashMap<>();
        studentToMark1.put(student1, 5);
        studentToMark1.put(student2, 3);
        studentToMark1.put(student3, 2);

        Map<Student, Integer> studentToMark2 = new HashMap<>();
        studentToMark2.put(student1, 5);
        studentToMark2.put(student2, 3);
        studentToMark2.put(student3, 2);

        Map<Student, Integer> studentToMark3 = new HashMap<>();
        studentToMark3.put(student1, 5);
        studentToMark3.put(student2, 3);
        studentToMark3.put(student3, 2);

        System.out.println("Добавляем предметов");
        universityDB.addSubject(subject1, studentToMark1);
        universityDB.addSubject(subject2, studentToMark2);
        universityDB.addSubject(subject3, studentToMark3);
        universityDB.printStudentsBySubject();
        universityDB.printMarksByStudent();

        System.out.println("Добавляем предмет Архитектура ПО к 3 студенту");
        universityDB.addSubjectToStudent(student3, subject4, 2);
        universityDB.printStudentsBySubject();
        universityDB.printMarksByStudent();

        System.out.println("Добавляем 2 студента к предмету Архитектура ПО");
        universityDB.addStudentToSubject(student2, subject4, 5);
        universityDB.printStudentsBySubject();
        universityDB.printMarksByStudent();

        //удаление студента
        System.out.println("Удаление 1-го студента");
        universityDB.removeStudent(student1);
        universityDB.printStudentsBySubject();
        universityDB.printMarksByStudent();

        //удаление студента из предмета
        System.out.println("Удаление 3-го студента из предмета Архитектура ПО");
        universityDB.removeStudentFromSubject(student3, subject4);
        universityDB.printStudentsBySubject();
        universityDB.printMarksByStudent();
    }
}
