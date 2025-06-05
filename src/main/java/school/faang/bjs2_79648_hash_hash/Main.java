package school.faang.bjs2_79648_hash_hash;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("Testing student methods");
        Subject math = new Subject("Math");
        Subject chemistry = new Subject("Chemistry");
        Subject logics = new Subject("Logics");

        Map<Subject, Integer> goodGrades = new HashMap<>();
        goodGrades.put(math, 100);
        goodGrades.put(chemistry, 95);
        goodGrades.put(logics, 90);
        Student studentGood = new Student("Welly");
        StudentDatabase.addStudentWithSubjects(studentGood, goodGrades);
        log.info("Added student Welly with good grades.");

        Map<Subject, Integer> sosoGrades = new HashMap<>();
        sosoGrades.put(math, 70);
        sosoGrades.put(chemistry, 75);
        sosoGrades.put(logics, 65);
        Student studentSoso = new Student("Avery");
        StudentDatabase.addStudentWithSubjects(studentSoso, sosoGrades);
        log.info("Added student Avery with average grades.");

        Map<Subject, Integer> badGrades = new HashMap<>();
        badGrades.put(math, 10);
        badGrades.put(chemistry, 9);
        badGrades.put(logics, 5);
        Student studentBad = new Student("Absent");
        StudentDatabase.addStudentWithSubjects(studentBad, badGrades);
        log.info("Added student Absent with bad grades.");

        log.info("Printing all added students with subjects.");
        StudentDatabase.printStudentsWithSubjects();

        log.info("Removing Absent");
        StudentDatabase.removeStudent(studentBad);
        StudentDatabase.printStudentsWithSubjects();

        log.info("Testing subject methods");
        StudentDatabase.printSubjectsWithStudents();

        log.info("Adding Physics to Absent and Welly");
        Subject physics = new Subject("Physics");
        StudentDatabase.addSubjectWithStudents(physics, List.of(studentGood, studentBad));
        StudentDatabase.printSubjectsWithStudents();
        StudentDatabase.printStudentsWithSubjects();

        log.info("Removing Absent from Physics");
        StudentDatabase.removeStudentFromSubject(studentBad, physics);
        StudentDatabase.printSubjectsWithStudents();
        StudentDatabase.printStudentsWithSubjects();
    }
}
