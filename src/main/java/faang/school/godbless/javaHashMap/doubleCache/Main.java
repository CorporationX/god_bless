package faang.school.godbless.javaHashMap.doubleCache;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private Map<Student, Map<Subject, Integer>> studentMap; // Список студентов и их оценки по предметам
    private Map<Subject, List<Student>> subjectMap; // Список предметов и студенты их изучающие

    public Main() {
        studentMap = new HashMap<>();
        subjectMap = new HashMap<>();

        Subject math = new Subject(0, "Math");
        Subject english = new Subject(1, "English");
        Subject history = new Subject(2, "History");


        Student oleg = new Student(0, "Oleg");
        Student vasya = new Student(1, "Vasya");
        Student yarik = new Student(2, "Yarik");
        Student alex = new Student(3, "Alex");
        Student ruslan = new Student(4, "Ruslan");
        Student danil = new Student(5, "Danil");
        Student elisey = new Student(6, "Elisey");

        subjectMap.put(math, new ArrayList<>(Arrays.asList(yarik, danil, ruslan)));
        subjectMap.put(english, new ArrayList<>(Arrays.asList(vasya, oleg)));
        subjectMap.put(history, new ArrayList<>(Arrays.asList(vasya, alex, elisey)));


        //Заполнение списка студентов и их оценок
        Map<Subject, Integer> olegGrades = new HashMap<>();
        olegGrades.put(english, 4);
        studentMap.put(oleg, olegGrades);

        Map<Subject, Integer> vasyaGrades = new HashMap<>();
        vasyaGrades.put(english, 5);
        vasyaGrades.put(history, 4);
        studentMap.put(vasya, vasyaGrades);

        Map<Subject, Integer> yarikGrades = new HashMap<>();
        yarikGrades.put(math, 4);
        studentMap.put(yarik, yarikGrades);

        Map<Subject, Integer> alexGrades = new HashMap<>();
        alexGrades.put(history, 5);
        studentMap.put(alex, alexGrades);

        Map<Subject, Integer> ruslanGrades = new HashMap<>();
        ruslanGrades.put(math, 3);
        studentMap.put(ruslan, ruslanGrades);

        Map<Subject, Integer> danilGrades = new HashMap<>();
        danilGrades.put(math, 5);
        studentMap.put(danil, danilGrades);

        Map<Subject, Integer> eliseyGrades = new HashMap<>();
        eliseyGrades.put(history, 5);
        studentMap.put(elisey, eliseyGrades);
    }

    public static void main(String[] args) {
        Main collegeManager = new Main();

        System.out.println("College Manager check. \nSystem storage at start point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding new student (Denis) with his grades.\n");

        Subject computerScience = new Subject(3, "Computer Science");
        Subject physical_education = new Subject(4, "Physical Education");

        Map<Subject, Integer> denisGrades = new HashMap<>();
        denisGrades.put(computerScience, 4);
        denisGrades.put(physical_education, 3);

        collegeManager.addStudentGrades(new Student(7, "Denis"), denisGrades);

        System.out.println("System storage at this point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");


        System.out.println("Adding new grades for Yarik (Computer Science and English)\n");

        Subject english = new Subject(1, "English");

        Map<Subject, Integer> yarikGrades = new HashMap<>();
        yarikGrades.put(computerScience, 3);
        yarikGrades.put(english, 3);

        collegeManager.addStudentGrades(new Student(2, "Yarik"), yarikGrades);

        System.out.println("System storage at this point:");

        collegeManager.printStudentsInfo();

        System.out.println();

        collegeManager.printSubjectsInfo();

        System.out.println("============================================\n");
    }

    //Also is able to add new student with his grades
    public void addStudentGrades(Student student, Map<Subject, Integer> grades) {
        studentMap.computeIfAbsent(student, subjectMap -> new HashMap<>()).putAll(grades);

        grades.forEach((subject, score) -> {
            subjectMap.computeIfAbsent(subject, studentList -> new ArrayList<>()).add(student);
        });
    }



    public void printStudentsInfo() {
        System.out.println("Students info:");
        studentMap.forEach((student, grades) -> {
            System.out.println("Student " + student.getName() + " and his(her) grades:");
            grades.forEach(((subject, score) -> {
                System.out.println(subject.getName() + " - " + score + ";");
            }));
            System.out.println();
        });
    }

    public void printSubjectsInfo() {
        System.out.println("Subjects info:");
        subjectMap.forEach((subject, students) -> {
            System.out.println("Subject " + subject.getName() + " and students assigned to it:");
            students.forEach(student -> {
                System.out.println(student.getName() + ";");
            });
            System.out.println();
        });
    }
}
