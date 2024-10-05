package school.faang.schitaem_proguly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final List<Student> STUDENTS = new LinkedList<>();
    private static final Map<Student, Integer> INDEX_STUDENTS = new HashMap<>();
    private static final Map<Cohort, List<Student>> COHORTS = new HashMap<>();

    public static void main(String[] args) {
        Student Masha = new Student("Masha", "Linguistics", 2015);
        Student Dasha = new Student("Dasha", "Linguistics", 2015);
        Student Grisha = new Student("Grisha", "Mathematics", 2005);
        Student Misha = new Student("Misha", "Physics", 2004);
        Student Borya = new Student("Borya", "Architecture", 2003);

        addStudent(Masha);
        addStudent(Dasha);
        addStudent(Grisha);
        addStudent(Misha);
        addStudent(Borya);
        formCohorts(STUDENTS);
        printAllStudents(COHORTS);
        findStudents("Linguistics", 2015);
        removeStudent(Borya);
        printAllStudents(COHORTS);

    }

    private static Map<Cohort, List<Student>> formCohorts(List<Student> STUDENTS) {
        for (Student student : STUDENTS) {
            Cohort cohort = new Cohort(student.getFACULTY(), student.getYEAR());
            COHORTS.computeIfAbsent(cohort, k -> new ArrayList<>()).add(student);
        }
        return COHORTS;
    }

    private static void addStudent(Student student) {
        STUDENTS.add(student);
        INDEX_STUDENTS.put(student, STUDENTS.size() - 1);
    }

    private static void removeStudent(Student student) {
        Integer index = INDEX_STUDENTS.get(student);
        if (index == null) {
            System.out.println("Student not found: " + student.getNAME());
            return;
        }
        STUDENTS.remove((int) index);
        INDEX_STUDENTS.remove(student);
        for (int i = index; i < STUDENTS.size(); i++) {
            Student s = STUDENTS.get(i);
            INDEX_STUDENTS.put(s, i);
        }
        Cohort removedStudentCohort = new Cohort(student.getFACULTY(), student.getYEAR());
        List<Student> cohortList = COHORTS.get(removedStudentCohort);
        if (cohortList != null) {
            cohortList.remove(student);
        }
        System.out.println("Removed student: " + student.getNAME());
    }

    private static void findStudents(String FACULTY, int YEAR) {
        List<Student> foundStudents = COHORTS.get(new Cohort(FACULTY, YEAR));
        if (foundStudents == null) {
            System.out.println("No students found");
        } else {
            foundStudents.forEach(student -> System.out.println(student.getNAME()));
        }
    }

    private static void printAllStudents(Map<Cohort, List<Student>> COHORTS) {
        COHORTS.forEach(((cohort, students) -> {
            System.out.println(cohort.toString() + ": ");
            for (Student student : students) {
                System.out.println(" " + student.getNAME());
            }
        }));
    }
}