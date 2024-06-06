package faang.school.godbless.studentDBHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    // допустим, что у нас одна школа с общей базой, сделаю пока так,
    // чтобы не передавать каждый раз мапы. Для реальной базы данных
    // если бы не задание, я бы лучше сделал мапу уроков как параметр у Student
    public static Map<Student, Map<Subject, Integer>> studentSubjects = new HashMap<>();

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
        if (students!=null) {
            students.add(student);
        } else {
            List<Student> newStudents = new ArrayList<>();
            newStudents.add(student);
            subjectStudentList.put(subject, newStudents);
        }
    }

    public static void subjectCheck(Subject subject, Student student, Map<Subject, Integer> subjects, int grade) {
        if (subjects!=null) {
            subjects.put(subject, grade);
        } else {
            Map<Subject, Integer> gradeSubject = new HashMap<>();
            gradeSubject.put(subject, grade);
            studentSubjects.put(student, gradeSubject);
        }
    }

    public static void removeStudent(Student student) {
        studentSubjects.remove(student);

        subjectStudentList.forEach((k, v) -> v.remove(student));
    }

    public static void removeSubject(Subject subject) {
        subjectStudentList.remove(subject);

        studentSubjects.forEach((k, v) -> v.remove(subject));
    }

    public static void outputStudentMap() {
        studentSubjects.forEach((k, v) -> System.out.println((k.toString() + ": " + v.toString())));
    }

    public static void outpputSubjectMap() {
        subjectStudentList.forEach((k,v) -> System.out.println((k.toString() + ": " + v.toString())));
    }


    public static void main(String[] args) {

        Student st0 = new Student(0, "Alen");
        Student st1 = new Student(1, "Bob");
        Student st2 = new Student(2, "Masha");


        Subject sbj0 = new Subject(0, "Math");
        Subject sbj1 = new Subject(1, "Bio");
        Subject sbj2 = new Subject(2, "Angl");
        Subject sbj3 = new Subject(3, "Geography");
        Subject sbj4 = new Subject(4, "Geometry");

        addNewStudent(sbj0, st0, 3);
        addNewStudent(sbj1, st0, 5);

        addNewStudent(sbj1, st1, 3);
        addNewStudent(sbj3, st1, 3);

        addNewStudent(sbj2, st2, 4);
        addNewStudent(sbj4, st2, 2);

        removeStudent(st1);
        removeSubject(sbj0);

        outputStudentMap();
        System.out.println();
        outpputSubjectMap();
    }
}
