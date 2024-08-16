package faang.school.godbless.cache;

import faang.school.godbless.cache.models.Student;
import faang.school.godbless.cache.models.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.cache.services.StudentService.*;
import static faang.school.godbless.cache.services.SubjectService.*;

public class Main {

    private final static Map<Student, Map<Subject, Integer>> STUDENTS_RATES = new HashMap<>();
    private final static Map<Subject, List<Student>> SUBJECTS_WITH_STUDENTS = new HashMap<>();

    public static void main(String[] args) {
        checkStudentService();
        checkSubjectService();
    }

    private static void checkStudentService() {
        Subject math = new Subject(1, "Math");
        Subject inf = new Subject(2, "Inf");

        Student bob = new Student("Bob");
        Student tom = new Student("Tom");
        Student test = new Student("TEST");
        Student anotherTest = new Student("TESTITO");

        System.out.println(SUBJECTS_WITH_STUDENTS);
        addNewStudentToSubjectInSubjectMap(math, bob, SUBJECTS_WITH_STUDENTS);
        addNewStudentToSubjectInSubjectMap(inf, tom, SUBJECTS_WITH_STUDENTS);

        printSubjectAndStudents(SUBJECTS_WITH_STUDENTS);
        System.out.println();

        Subject eng = new Subject(3, "Eng");
        List<Student> students = new ArrayList<>();
        students.add(test);
        students.add(anotherTest);
        addNewSubjectAndStudentListInSubjectMap(eng, students, SUBJECTS_WITH_STUDENTS);
        printSubjectAndStudents(SUBJECTS_WITH_STUDENTS);
        System.out.println();

        addNewStudentToSubjectInSubjectMap(eng, bob, SUBJECTS_WITH_STUDENTS);
        printSubjectAndStudents(SUBJECTS_WITH_STUDENTS);
        System.out.println();

        removeStudentFromSubject(eng, bob, SUBJECTS_WITH_STUDENTS);
        printSubjectAndStudents(SUBJECTS_WITH_STUDENTS);
        System.out.println();
    }

    private static void checkSubjectService() {
        Student bob = new Student("Bob");

        Subject math = new Subject(1, "Math");
        Subject inf = new Subject(2, "Inf");

        Student test = new Student("TEST");

        addNewSubjectForStudent(bob, math, 2, STUDENTS_RATES);
        addNewSubjectForStudent(bob, inf, 4, STUDENTS_RATES);

        addNewSubjectForStudent(test, math, 2, STUDENTS_RATES);
        addNewSubjectForStudent(test, inf, 4, STUDENTS_RATES);

        printStudentsAndRatesBySubject(STUDENTS_RATES);
        System.out.println();
        Student tom = new Student("Tom");

        HashMap<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        subjects.put(inf, 0);

        addNewStudentInStudentRatesWithAllSubjects(tom, subjects, STUDENTS_RATES);

        printStudentsAndRatesBySubject(STUDENTS_RATES);

        System.out.println();
        removeStudentFromStudentsRates(test, STUDENTS_RATES);
        printStudentsAndRatesBySubject(STUDENTS_RATES);

        addNewStudentInStudentRatesWithAllSubjects(test, subjects, STUDENTS_RATES);
        printStudentsAndRatesBySubject(STUDENTS_RATES);
    }
}
