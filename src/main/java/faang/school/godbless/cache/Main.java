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

    public static HashMap<Student, Map<Subject, Integer>> studentsRates = new HashMap<>();
    public static HashMap<Subject, List<Student>> subjectsWithStudents = new HashMap<>();

    public static void main(String[] args) {
        checkStudentService();
        checkSubjectService();
    }

    public static void checkStudentService() {
        Subject math = new Subject(1, "Math");
        Subject inf = new Subject(2, "Inf");

        Student bob = new Student("Bob");
        Student tom = new Student("Tom");
        Student test = new Student("TEST");
        Student anotherTest = new Student("TESTITO");

        System.out.println(subjectsWithStudents);
        addNewStudentToSubjectInSubjectMap(math, bob);
        addNewStudentToSubjectInSubjectMap(inf, tom);

        printSubjectAndStudents();
        System.out.println();

        Subject eng = new Subject(3, "Eng");
        List<Student> students = new ArrayList<>();
        students.add(test);
        students.add(anotherTest);
        addNewSubjectAndStudentListInSubjectMap(eng, students);
        printSubjectAndStudents();
        System.out.println();

        addNewStudentToSubjectInSubjectMap(eng, bob);
        printSubjectAndStudents();
        System.out.println();

        removeStudentFromSubject(eng, bob);
        printSubjectAndStudents();
        System.out.println();
    }

    public static void checkSubjectService() {
        Student bob = new Student("Bob");

        Subject math = new Subject(1, "Math");
        Subject inf = new Subject(2, "Inf");

        Student test = new Student("TEST");

        addNewSubjectForStudent(bob, math, 2);
        addNewSubjectForStudent(bob, inf, 4);

        addNewSubjectForStudent(test, math, 2);
        addNewSubjectForStudent(test, inf, 4);

        printStudentsAndRatesBySubject();
        System.out.println();
        Student tom = new Student("Tom");

        HashMap<Subject, Integer> subjects = new HashMap<>();
        subjects.put(math, 5);
        subjects.put(inf, 0);

        addNewStudentInStudentRatesWithAllSubjects(tom, subjects);

        printStudentsAndRatesBySubject();

        System.out.println();
        removeStudentFromStudentsRates(test);
        printStudentsAndRatesBySubject();

        addNewStudentInStudentRatesWithAllSubjects(test, subjects);
        printStudentsAndRatesBySubject();
    }
}
