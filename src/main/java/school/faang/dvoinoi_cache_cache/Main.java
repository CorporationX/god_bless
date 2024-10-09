package school.faang.dvoinoi_cache_cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_SUBJECTS_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> SUBJECTS_AND_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        Student Masha = new Student(1, "Masha");
        Student Dasha = new Student(2, "Dasha");
        Student Grisha = new Student(3, "Grisha");
        Student newStudentMisha = new Student(4, "Misha");

        Subject philosophy = new Subject(1, "philosophy");
        Subject mathematics = new Subject(2, "mathematics");
        Subject physics = new Subject(3, "physics");

        Map<Subject, Integer> mishasGrades = Map.of(
                philosophy, 5,
                physics, 4,
                mathematics, 4
        );

        addStudentAndTheirGrades(newStudentMisha, mishasGrades);
        addSubjectAndGradeForAnExistingStudent(Dasha, mathematics, 4);
        addStudentAndTheirGrades(Dasha, null);
        addStudentAndTheirGrades(Masha, null);
        removeStudentAndTheirSubjectsAndGrades(Masha);
        printAllStudentsWithTheirSubjectsAndGrades();
        addNewSubjectAndParticipatingStudents(physics, Masha, Dasha);
        addStudentToAnExistingSubject(physics, Grisha);
        removeStudentFromSubject(physics, Grisha);
        printAllSubjectsAndStudents();
    }

    public static void addStudentAndTheirGrades(Student student, Map<Subject, Integer> grades) {
        STUDENT_SUBJECTS_GRADES.put(student, grades);
    }

    public static void addSubjectAndGradeForAnExistingStudent(Student student, Subject subject, Integer grade) {
        Map<Subject, Integer> subjectGrades = STUDENT_SUBJECTS_GRADES.get(student);
        if (subjectGrades != null) {
            subjectGrades.put(subject, grade);
        } else {
            System.out.println("Student not found, use addStudentAndTheirGrades method instead");
        }
    }

    public static void removeStudentAndTheirSubjectsAndGrades(Student student) {
        STUDENT_SUBJECTS_GRADES.remove(student);
    }

    public static void printAllStudentsWithTheirSubjectsAndGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_SUBJECTS_GRADES.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void addNewSubjectAndParticipatingStudents(Subject subject, Student... students) {
        List<Student> studentList = SUBJECTS_AND_STUDENTS.computeIfAbsent(subject, k -> new ArrayList<>());
        studentList.addAll(Arrays.asList(students));
    }

    public static void addStudentToAnExistingSubject(Subject subject, Student student) {
        List<Student> students = SUBJECTS_AND_STUDENTS.get(subject);
        if (students != null) {
            students.add(student);
        } else {
            System.out.println("Subject not found, use addNewSubjectAndParticipatingStudents method instead");
        }
    }

    public static void removeStudentFromSubject(Subject subject, Student student) {
        List<Student> students = SUBJECTS_AND_STUDENTS.get(subject);
        if (students == null) {
            System.out.println("Subject not found: " + subject.getName());
            return;
        }
        boolean removed = students.remove(student);
        if (removed) {
            System.out.println("Removed student " + student.getName() + " from subject " + subject.getName());
        } else {
            System.out.println("Student " + student.getName() + " is not enrolled in subject + " + subject.getName());
        }

    }

    public static void printAllSubjectsAndStudents() {
        for (Map.Entry<Subject, List<Student>> entry : SUBJECTS_AND_STUDENTS.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
