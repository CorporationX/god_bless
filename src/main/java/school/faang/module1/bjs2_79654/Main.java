package school.faang.module1.bjs2_79654;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class Main {

    private static Student alana = new Student("Alana");
    private static Student bob = new Student("Bob");
    private static Student charlie = new Student("Charlie");

    private static Subject math = new Subject("Math");
    private static Subject physics = new Subject("Physics");
    private static Subject literature = new Subject("Literature");

    public static void main(String[] args) {
        log.info("Initializing StudentDatabase");
        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());

        Map<Subject, Optional<Integer>> alanaGrades = new HashMap<>();
        alanaGrades.put(math, Optional.of(9));
        alanaGrades.put(physics, Optional.of(8));
        database.addStudentWithSubjects(alana, alanaGrades);

        Map<Subject, Optional<Integer>> bobGrades = new HashMap<>();
        bobGrades.put(math, Optional.of(10));
        bobGrades.put(literature, Optional.of(7));
        database.addStudentWithSubjects(bob, bobGrades);

        log.info("Students with subjects and grades added");

        database.addSubjectToStudent(alana, literature, 10);
        log.info("Added Literature subject with grade 10 for Alana");

        List<Student> physicsStudents = new ArrayList<>();
        physicsStudents.add(bob);
        physicsStudents.add(charlie);
        database.addSubjectWithStudents(physics, physicsStudents);
        log.info("Added Physics subject with Bob and Charlie");

        database.addStudentToSubject(literature, charlie);
        log.info("Charlie added to Literature subject");

        log.info("Students and their grades");
        System.out.println(database.getAllStudentsWithGrades());

        log.info("Subjects and students");
        System.out.println(database.getAllSubjectsWithStudents());

        database.removeStudentFromSubject(math, alana);
        log.info("Alana removed from Math subject");

        database.removeStudent(bob);
        log.info("Bob completely removed");

        log.info("After removals");
        System.out.println(database.getAllStudentsWithGrades());
        System.out.println(database.getAllSubjectsWithStudents());
    }
}