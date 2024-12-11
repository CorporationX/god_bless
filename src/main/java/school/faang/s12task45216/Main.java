package school.faang.s12task45216;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static StudentDatabase sd;

    public static void main(String[] args) {
        HashMap<Student, Map<Subject, Integer>> subjectsWithGrades = new HashMap<>();
        HashMap<Subject, List<Student>> subjectWithStudents = new HashMap<>();
        sd = new StudentDatabase(subjectsWithGrades, subjectWithStudents);

        Student student1 = new Student(1, "Sam Kan");
        Student student2 = new Student(2, "Kim Pack");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Subject subject1 = new Subject(3, "Math");
        Subject subject2 = new Subject(4, "Physics");
        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put(subject1, 4);
        grades1.put(subject2, 4);
        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put(subject1, 5);
        grades2.put(subject2, 5);

        testAddStudentWithSubjectsAndGrades(student1, grades1);
        testAddStudentWithSubjectsAndGrades(student2, grades2);
        testAddSubjectForStudent(student1, subject1, 3);
        testAddSubjectForStudent(student1, subject2, 3);
        testRemoveStudentWithSubjects(student1);
        testPrintAllStudentsWithSubjectsAndGrades();

        testAddSubjectWithStudents(subject1, students);
        testAddSubjectWithStudents(subject2, students);
        tesAddStudentToSubject(student1, subject1);
        tesAddStudentToSubject(student2, subject1);
        testRemoveStudentFromSubject(student2, subject1);
        testPrintAllSubjectsWithStudents();
    }

    public static void testAddStudentWithSubjectsAndGrades(Student student, Map<Subject, Integer> grades) {
        sd.addStudentWithSubjectsAndGrades(student, grades);
    }

    public static void testAddSubjectForStudent(Student student, Subject subject, int grade) {
        sd.addSubjectForStudent(student, subject, grade);
    }

    public static void testRemoveStudentWithSubjects(Student student) {
        sd.removeStudentWithSubjects(student);
    }

    public static void testPrintAllStudentsWithSubjectsAndGrades() {
        sd.printAllStudentsWithSubjectsAndGrades();
    }

    public static void testAddSubjectWithStudents(Subject subject, List<Student> students) {
        sd.addSubjectWithStudents(subject, students);
    }

    public static void tesAddStudentToSubject(Student student, Subject subject) {
        sd.addStudentToSubject(student, subject);
    }

    public static void testRemoveStudentFromSubject(Student student, Subject subject) {
        sd.removeStudentFromSubject(student, subject);
    }

    public static void testPrintAllSubjectsWithStudents() {
        sd.printAllSubjectsWithStudents();
    }
}