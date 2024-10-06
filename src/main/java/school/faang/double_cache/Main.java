package school.faang.double_cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_GRADES = new HashMap<>();
    private  static final Map<Subject, List<Student>> STUDENTS_STUDYING_SUBJECT = new HashMap<>();

    public static void main(String[] args) {
        Student studentOne = new Student(1, "Oleg");
        Student studentTwo = new Student(2, "Evgen");
        List<Student> studentsFromSubject = List.of(studentOne, studentTwo);
        Subject subjectMath = new Subject(1, "math");
        Subject subjectBiolog = new Subject(2, "Biologia");
        Map<Subject, Integer> subjectAndGrade = new HashMap<>();
        subjectAndGrade.put(subjectMath, 4);
        subjectAndGrade.put(subjectBiolog, 5);
        addStudentAndSubjects(studentOne, subjectAndGrade);
        addSubjectWithStudents(subjectBiolog, studentsFromSubject);
        addSubjectWithStudents(subjectMath, studentsFromSubject);
        showAllStudentsWitchGrades();
        showAllSubjectsWithStudents();
    }

    public static void addStudentAndSubjects(Student student, Map<Subject, Integer> subjects) {
        if (student == null || subjects == null) {
            throw new IllegalArgumentException("В методе addStudentAndSubjects: Аргументы не должны быть null!");
        }
        STUDENT_SUBJECTS_GRADES.put(student, subjects);
    }

    public static void addSubjectFromStudent(Student student, Subject subject, int grade) {
        if (student == null || subject == null || grade <= 0) {
            throw new IllegalArgumentException("у метода dev_maksim-BJS2-32822: есть неверное или пустое значение");
        }
        STUDENT_SUBJECTS_GRADES.get(student).put(subject, grade);
    }

    public static void removeStudentFromList(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student is null");
        }
        STUDENT_SUBJECTS_GRADES.remove(student);
    }

    public static void showAllStudentsWitchGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECTS_GRADES.entrySet()) {
            Student student = entry.getKey();
            Map<Subject, Integer> subjectIntegerMap = entry.getValue();
            System.out.println("Студент " + student.name() +" имеет предметы с оценками: ");
            for (Map.Entry<Subject, Integer> subject : subjectIntegerMap.entrySet()) {
                String nameSubject = subject.getKey().name();
                Integer grade = subject.getValue();
                System.out.println("предмет- " + nameSubject + " с оценкой- " + grade);
            }
        }
    }

    public static void addSubjectWithStudents(Subject subject, List<Student> students) {
        if (subject == null || students == null) {
            throw new IllegalArgumentException("В методе addSubjectWithStudents: есть пустые аргуманты");
        }
        STUDENTS_STUDYING_SUBJECT.put(subject, students);
    }

    public static void addStudentFromSubject(Subject subject, Student student) {
        if (subject == null || student == null) {
            throw new IllegalArgumentException("В методе addStudentFromSubject: есть пустые аргуманты");
        }
        STUDENTS_STUDYING_SUBJECT.get(subject).add(student);
    }

    public static void removeStudentInSubject(Student student, Subject subject) {
        if (student == null) {
            throw new IllegalArgumentException("в методе removeStudentInSubject: student равен null");
        }
        STUDENTS_STUDYING_SUBJECT.get(subject).remove(student);
    }

    public static void showAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : STUDENTS_STUDYING_SUBJECT.entrySet()) {
            String nameSubject = entry.getKey().name();
            List<Student> studentsThisSubject = entry.getValue();
            System.out.println(nameSubject + " : на нем учатся : " + studentsThisSubject);
        }
    }
}
