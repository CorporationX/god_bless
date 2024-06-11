package faang.school.godbless.core_split.student_db_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // допустим, что у нас одна школа с общей базой, сделаю пока так,
    // чтобы не передавать каждый раз мапы. Для реальной базы данных
    // если бы не задание, я бы лучше сделал мапу уроков как параметр у Student
    public final static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

    // аналогично сделал бы лист студентов как параметр в Subject
    public static Map<Subject, List<Student>> subjectStudentList = new HashMap<>();

    // есть проверка, если предмет новый, поэтому не вижу смысла разделять логику
    // сделал отдельные методы для проверок, вроде читабельней
    public static void addNewStudent(Subject subject, Student student, int grade) {
        List<Student> studentsInSubjectList = subjectStudentList.get(subject);
        // проверка на новый предмет c добавлением
        studentCheck(subject, student, studentsInSubjectList);

        Map<Subject, Integer> subjectsInStudentMap = studentSubjects.get(student);
        // проверка на нового студента c добавлением
        subjectCheck(subject, student, subjectsInStudentMap, grade);

    }

    public static void studentCheck(Subject subject, Student student, List<Student> students) {
        if (students != null) {
            students.add(student);
            return;
        }
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(student);
        subjectStudentList.put(subject, newStudents);

    }

    public static void subjectCheck(Subject subject, Student student, Map<Subject, Integer> subjects, int grade) {
        if (subjects != null) {
            subjects.put(subject, grade);
            return;
        }
        Map<Subject, Integer> gradeSubject = new HashMap<>();
        gradeSubject.put(subject, grade);
        studentSubjects.put(student, gradeSubject);

    }

    public static void removeStudent(Student stud) {
        studentSubjects.remove(stud);

        subjectStudentList.forEach((k, v) -> v.remove(stud));
    }

    public static void removeSubject(Subject sbj) {
        subjectStudentList.remove(sbj);

        studentSubjects.forEach((k, v) -> v.remove(sbj));
    }

    public static void outputStudentMap() {
        studentSubjects.forEach((k, v) -> System.out.println((k.toString() + ": " + v.toString())));
    }

    public static void outpputSubjectMap() {
        subjectStudentList.forEach((k, v) -> System.out.println((k.toString() + ": " + v.toString())));
    }


    public static void main(String[] args) {

        Student alen = new Student(0, "Alen");
        Student bob = new Student(1, "Bob");
        Student masha = new Student(2, "Masha");


        Subject math = new Subject(0, "Math");
        Subject bio = new Subject(1, "Bio");
        Subject angl = new Subject(2, "Angl");
        Subject geography = new Subject(3, "Geography");
        Subject geometry = new Subject(4, "Geometry");

        addNewStudent(math, alen, 3);
        addNewStudent(bio, alen, 5);

        addNewStudent(geometry, bob, 3);
        addNewStudent(angl, bob, 3);

        addNewStudent(angl, masha, 4);
        addNewStudent(geography, masha, 2);

        removeStudent(bob);
        removeSubject(angl);

        outputStudentMap();
        System.out.println();
        outpputSubjectMap();
    }
}
