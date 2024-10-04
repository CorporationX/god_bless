package ru.kraiush.BJS2_32378;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<Student, Map<Subject, Integer>> STUDENT_GRADES = new HashMap<>();
    private static final Map<Subject, List<Student>> STUDENTS_OF_SUBJECT = new HashMap<>();

    private static void addStudentAndSubjectsWithGrades(Student student, Map<Subject, Integer> grades) {
        STUDENT_GRADES.put(student, grades);
    }

    private static void addSubjectWithGradeToStudent(Student student, Subject subject, int grade) {
        STUDENT_GRADES.get(student).put(subject, grade);
    }

    private static void deleteStudentAndSubjectsWithGrades(Student student) {
        STUDENT_GRADES.remove(student);
    }

    private static void getAllStudentsAndSubjectsWithGrades() {
        for (Map.Entry<Student, Map<Subject, Integer>> entry : STUDENT_GRADES.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void addSubjectAndStudents(Subject subject, List<Student> students) {
        STUDENTS_OF_SUBJECT.put(subject, students);
    }

    private static void addStudentToSubject(Student student, Subject subject) {
        STUDENTS_OF_SUBJECT.get(subject).add(student);
    }

    private static void deleteStudentFromSubject(Student student, Subject subject) {
        STUDENTS_OF_SUBJECT.get(subject).remove(student);
    }

    private static void getAllSubjectsWithStudents() {
        for (Map.Entry<Subject, List<Student>> entry : STUDENTS_OF_SUBJECT.entrySet()) {
            System.out.println(entry.getKey() + " - Students: " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Subject biology = new Subject(1, "Biology");
        Subject math = new Subject(2, "Math");
        Subject physics = new Subject(3, "Physics");
        Subject literature = new Subject(4, "Literature");

        Student samSmith = new Student(1, "Sam Smith");
        Map<Subject, Integer> samSmithSubjectsWithGrades = new HashMap<>();
        samSmithSubjectsWithGrades.put(biology, 4);
        samSmithSubjectsWithGrades.put(math, 5);

        Student chrisBrown = new Student(2, "Chris Brown");
        Map<Subject, Integer> chrisBrownSubjectsWithGrades = new HashMap<>();
        chrisBrownSubjectsWithGrades.put(biology, 5);
        chrisBrownSubjectsWithGrades.put(physics, 4);
        chrisBrownSubjectsWithGrades.put(literature, 4);

        Student emmaStone = new Student(3, "Emma Stone");
        Map<Subject, Integer> emmaStoneSubjectsWithGrades = new HashMap<>();
        emmaStoneSubjectsWithGrades.put(physics, 4);
        emmaStoneSubjectsWithGrades.put(literature, 5);

        Student ellaGrey = new Student(4, "Ella Grey");
        Map<Subject, Integer> ellaGreySubjectsWithGrades = new HashMap<>();
        ellaGreySubjectsWithGrades.put(biology, 5);
        ellaGreySubjectsWithGrades.put(literature, 4);

        Student henryFord = new Student(5, "Henry Ford");
        Map<Subject, Integer> henryFordSubjectsWithGrades = new HashMap<>();
        henryFordSubjectsWithGrades.put(math, 3);
        henryFordSubjectsWithGrades.put(literature, 4);

        Student davidJones = new Student(6, "David Jones");
        Map<Subject, Integer> davidJonesSubjectsWithGrades = new HashMap<>();
        davidJonesSubjectsWithGrades.put(biology, 5);
        davidJonesSubjectsWithGrades.put(physics, 3);
        davidJonesSubjectsWithGrades.put(literature, 4);

        Student amyLee = new Student(7, "Amy Lee");
        Map<Subject, Integer> amyLeeSubjectsWithGrades = new HashMap<>();
        amyLeeSubjectsWithGrades.put(biology, 5);
        amyLeeSubjectsWithGrades.put(math, 5);

        List<Student> studentsOfBiology = new ArrayList<>();
        studentsOfBiology.add(samSmith);
        studentsOfBiology.add(chrisBrown);
        studentsOfBiology.add(ellaGrey);
        studentsOfBiology.add(davidJones);
        studentsOfBiology.add(amyLee);

        List<Student> studentsOfMath = new ArrayList<>();
        studentsOfMath.add(samSmith);
        studentsOfMath.add(henryFord);
        studentsOfMath.add(amyLee);

        List<Student> studentsOfPhysics = new ArrayList<>();
        studentsOfPhysics.add(chrisBrown);
        studentsOfPhysics.add(emmaStone);
        studentsOfPhysics.add(davidJones);

        List<Student> studentsOfLiterature = new ArrayList<>();
        studentsOfLiterature.add(chrisBrown);
        studentsOfLiterature.add(emmaStone);
        studentsOfLiterature.add(ellaGrey);
        studentsOfLiterature.add(henryFord);
        studentsOfLiterature.add(davidJones);

        addStudentAndSubjectsWithGrades(samSmith, samSmithSubjectsWithGrades);
        addStudentAndSubjectsWithGrades(chrisBrown, chrisBrownSubjectsWithGrades);
        addStudentAndSubjectsWithGrades(emmaStone, emmaStoneSubjectsWithGrades);
        addStudentAndSubjectsWithGrades(ellaGrey, ellaGreySubjectsWithGrades);
        addStudentAndSubjectsWithGrades(henryFord, henryFordSubjectsWithGrades);
        addStudentAndSubjectsWithGrades(davidJones, davidJonesSubjectsWithGrades);
        addStudentAndSubjectsWithGrades(amyLee, amyLeeSubjectsWithGrades);

        addSubjectWithGradeToStudent(henryFord, biology, 5);
        addSubjectWithGradeToStudent(davidJones, math, 3);
        addSubjectWithGradeToStudent(samSmith, physics, 5);

        deleteStudentAndSubjectsWithGrades(amyLee);

        getAllStudentsAndSubjectsWithGrades();

        addSubjectAndStudents(biology, studentsOfBiology);
        addSubjectAndStudents(math, studentsOfMath);
        addSubjectAndStudents(physics, studentsOfPhysics);
        addSubjectAndStudents(literature, studentsOfLiterature);

        addStudentToSubject(henryFord, biology);
        addStudentToSubject(davidJones, math);
        addStudentToSubject(samSmith, physics);

        deleteStudentFromSubject(amyLee, biology);
        deleteStudentFromSubject(amyLee, math);

        getAllSubjectsWithStudents();
    }
}
