package doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentSubjectService {
    private static final int GRADE_BY_DEFAULT = 0;

    private static Map<Student, Map<Subject, Integer>> subjectsAndGradesByStudent = new HashMap<>();
    private static Map<Subject, List<Student>> studentsBySubject = new HashMap<>();

    public static void cacheMatching(Student student, Subject subject, int grade) {
        if (subjectsAndGradesByStudent.get(student) != null) {
            subjectsAndGradesByStudent.get(student).putIfAbsent(subject, grade);
        } else {
            Map<Subject, Integer> subjectAndGradesOfNewStudent = new HashMap<>();
            subjectAndGradesOfNewStudent.put(subject, grade);
            subjectsAndGradesByStudent.put(student, subjectAndGradesOfNewStudent);
        }

        if (studentsBySubject.get(subject) != null) {
            if (!studentsBySubject.get(subject).contains(student)) {
                studentsBySubject.get(subject).add(student);
            }
        } else {
            List<Student> studentsOfNewSubject = new ArrayList<>();
            studentsOfNewSubject.add(student);
            studentsBySubject.put(subject, studentsOfNewSubject);
        }
    }

    public static void addStudentWithGradesAndSubjects(Student student, Map<Subject, Integer> subjectsAndGrades) {
        for (var subject : subjectsAndGrades.entrySet()) {
            addSubjectForStudent(student, subject.getKey(), subject.getValue());
        }
    }

    public static void addSubjectForStudent(Student student, Subject subject, int grade) {
        cacheMatching(student, subject, grade);
    }

    public static void removeStudent(Student student) {
        if (!subjectsAndGradesByStudent.containsKey(student)) {
            return;
        }

        for (var subject : subjectsAndGradesByStudent.get(student).entrySet()) {
            studentsBySubject.get(subject.getKey()).remove(student);
        }

        subjectsAndGradesByStudent.remove(student);
    }

    public static void printAllStudentsWithGrades() {
        for (var student : subjectsAndGradesByStudent.entrySet()) {
            System.out.println("Студент: " + student.getKey().getName());
            for (var subject : student.getValue().entrySet()) {
                System.out.println(subject.getKey().getName() + ": " + subject.getValue());
            }
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        for (var student : students) {
            addStudentForSubject(student, subject);
        }
    }

    public static void addStudentForSubject(Student student, Subject subject) {
        cacheMatching(student, subject, GRADE_BY_DEFAULT);
    }

    public static void removeStudentFromSubject(Student student, Subject subject) {
        if (!studentsBySubject.containsKey(subject)) {
            return;
        }
        studentsBySubject.get(subject).remove(student);
        subjectsAndGradesByStudent.get(student).remove(subject);
    }

    public static void printAllSubjectWithStudents() {
        for (var subject : studentsBySubject.entrySet()) {
            System.out.println("Предмет: " + subject.getKey().getName());
            for (var student : subject.getValue()) {
                System.out.println(student.getName());
            }
        }
    }
}