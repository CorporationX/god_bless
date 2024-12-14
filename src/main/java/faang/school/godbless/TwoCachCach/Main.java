package faang.school.godbless.TwoCachCach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Student, Map<Subject, Integer>> gradesInSubject = new HashMap<>();
    private static Map<Subject, List<Student>> subjectAndStudents = new HashMap<>();

    public static void main(String[] args) {
        Student s1 = new Student(1, "AAA");
        Student s2 = new Student(2, "BBB");
        Student s3 = new Student(3, "CCC");
        Student s4 = new Student(4, "CCCSAF");

        Subject sb1 = new Subject(1, "mmm");
        Subject sb2 = new Subject(2, "nnn");
        Subject sb3 = new Subject(3, "iii");

        Map<Subject, Integer> ma = new HashMap<>();
        ma.put(sb1, 4);
        ma.put(sb2, 5);
        ma.put(sb3, 4);

        addStudent(s1, ma);
        addNewSubjectByStudent(s1, new Subject(4, "jjj"), 3);
        allStudentAndGrades();

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        addSubjectAndListStudent(sb1, studentList);
        addNewStudentBySubject(s4, sb1);
        allSubjectsAndStudents();
    }

    static void addStudent(Student student, Map<Subject, Integer> subjectIntegerMap) {
        gradesInSubject.put(student, subjectIntegerMap);
    }

    static void addNewSubjectByStudent(Student student, Subject subject, int grades) {
        gradesInSubject.get(student).put(subject, grades); // добавить проверку, есть такой предмет или нет?
    }

    static void deleteStudent(Student student) {
        gradesInSubject.remove(student);
    }

    static void allStudentAndGrades() {
        for (var map : gradesInSubject.entrySet()) {
            System.out.println(map.getKey() + "-> " + map.getValue().values().stream().toList());
        }
    }

    //работа со 2 мапой
    static void addSubjectAndListStudent(Subject subject, List<Student> studentList) {
        subjectAndStudents.put(subject, studentList);
    }

    static void addNewStudentBySubject(Student student, Subject subject) {
        subjectAndStudents.get(subject).add(student); // проверку на наличие
    }

    static void deleteStudentFromSubject(Student student, Subject subject) {
        subjectAndStudents.get(subject).remove(student);
    }

    static void allSubjectsAndStudents() {
        for (var map : subjectAndStudents.entrySet()) {
            System.out.println(map.getKey() + "-> " + map.getValue());
        }
    }
}
