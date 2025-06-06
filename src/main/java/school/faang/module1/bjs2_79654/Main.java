package school.faang.module1.bjs2_79654;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Initializing StudentDatabase");
        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());

        Student alana = new Student("Alana");
        Student bob = new Student("Bob");
        Student charlie = new Student("Charlie");

        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject literature = new Subject("Literature");

        Map<Subject, Integer> alanaGrades = new HashMap<>();
        alanaGrades.put(math, 9);
        alanaGrades.put(physics, 8);
        database.addStudentWithSubjects(alana, alanaGrades);

        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(math, 10);
        bobGrades.put(literature, 7);
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
        database.printAllStudentsWithGrades();

        log.info("Subjects and students");
        database.printAllSubjectsWithStudents();

        database.removeStudentFromSubject(math, alana);
        log.info("Alana removed from Math subject");

        database.removeStudent(bob);
        log.info("Bob completely removed");

        log.info("After removals");
        database.printAllStudentsWithGrades();
        database.printAllSubjectsWithStudents();
    }
}
