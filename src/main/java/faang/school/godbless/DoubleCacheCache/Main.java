package faang.school.godbless.DoubleCacheCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_BY_SUBJECTS = new HashMap<>();

    public static void main(String[] args) {
        Student valera = new Student("valera");
        Student danya = new Student("danya");

        Subject math = new Subject("Math");
        Subject rus = new Subject("Rus");
        Subject fiz = new Subject("Fiz");

        addStudentsWithSubjectsGrades(valera, math, 5);
        addStudentsWithSubjectsGrades(valera, rus, 4);
        addStudentsWithSubjectsGrades(valera, fiz, 5);

        addStudentsWithSubjectsGrades(danya, math, 5);
        addStudentsWithSubjectsGrades(danya, rus, 5);

        List<Student> students = new ArrayList<>();
        students.add(valera);
        students.add(danya);

        addSubjectWithStudents(math, students);
        addSubjectWithStudents(rus, students);
        addStudentToSubject(fiz, valera);

        printStudentsWithSubjectsGrades();
        printSubjectAndStudents();

        addStudentToSubject(fiz, danya);
        addSubjectWithGradeToStudent(danya, fiz, 3);

        printStudentsWithSubjectsGrades();
        printSubjectAndStudents();

        deleteStudentFromSubject(fiz, danya);

        printSubjectAndStudents();

        deleteStudentWithSubjectsGrades(danya);

        printStudentsWithSubjectsGrades();

    }

    private static void addStudentsWithSubjectsGrades(Student student, Subject subject, int grade) {
        STUDENT_SUBJECTS_GRADES.putIfAbsent(student, new HashMap<>());
        STUDENT_SUBJECTS_GRADES.get(student).put(subject, grade);
    }

    private static void addSubjectWithGradeToStudent(Student student, Subject subject, int grade) {
        STUDENT_SUBJECTS_GRADES.get(student).put(subject, grade);
    }

    private static void deleteStudentWithSubjectsGrades(Student student) {
        STUDENT_SUBJECTS_GRADES.remove(student);
    }

    private static void printStudentsWithSubjectsGrades() {
        STUDENT_SUBJECTS_GRADES.forEach((student, subjectGrade) ->
        {
            System.out.println(student.getName());
            subjectGrade.forEach((subject, grade) -> {
                System.out.println(subject.getName() + " : " + grade);
            });
            System.out.println("________________________________");
        });
        System.out.println("\n");
    }

    private static void addSubjectWithStudents(Subject subject, List<Student> students) {
        STUDENTS_BY_SUBJECTS.putIfAbsent(subject, new ArrayList<>());
        students.forEach(student -> {
            STUDENTS_BY_SUBJECTS.get(subject).add(student);
        });
    }

    private static void addStudentToSubject(Subject subject, Student student) {
        STUDENTS_BY_SUBJECTS.putIfAbsent(subject, new ArrayList<>());
        STUDENTS_BY_SUBJECTS.get(subject).add(student);
    }

    private static void deleteStudentFromSubject(Subject subject, Student student)
    {
        STUDENTS_BY_SUBJECTS.get(subject).remove(student);
    }

    private static void printSubjectAndStudents()
    {
        STUDENTS_BY_SUBJECTS.forEach((subject, students) ->
        {
            System.out.println(subject.getName());
            students.forEach( student -> {
                System.out.println(student.getName());
            });
            System.out.println("________________________________");
        });
        System.out.println("\n");
    }
}
