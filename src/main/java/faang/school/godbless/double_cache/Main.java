package faang.school.godbless.double_cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> mapStudentSubject = new HashMap<>();
    private static final Map<Subject, List<Student>> subjects = new HashMap<>();

    public static void main(String[] args) {
        Student alice = new Student( 1, "Alice" );
        Student bob = new Student( 2, "Bob" );

        Subject subject1 = new Subject( 101, "Math" );
        Subject subject2 = new Subject( 102, "Physics" );

        Map<Subject, Integer> grades1 = new HashMap<>();
        grades1.put( subject1, 90 );
        grades1.put( subject2, 85 );

        Map<Subject, Integer> grades2 = new HashMap<>();
        grades2.put( subject1, 75 );
        grades2.put( subject2, 80 );

        mapStudentSubject.put( alice, grades1 );
        mapStudentSubject.put( bob, grades2 );

        List<Student> studentsForSub1 = new ArrayList<>();
        studentsForSub1.add( alice );
        studentsForSub1.add( bob );
        List<Student> studentsForSub2 = new ArrayList<>();
        studentsForSub2.add( alice );
        studentsForSub2.add( bob );

        subjects.put( subject1, studentsForSub1 );
        subjects.put( subject2, studentsForSub2 );

        printAllStudentAndGrades();
        System.out.println( "*******************************************************" );
        printAllStudentsInSubject();

        Student kyle = new Student( 2, "Kyle" );
        addNewStudent( kyle, grades1 );

        System.out.println( "*******************************************************" );
        printAllStudentsInSubject();
        deleteStudent( alice );
        System.out.println( "*******************************************************" );
        printAllStudentAndGrades();
        System.out.println( "*******************************************************" );
        deleteStudentFromSubject( alice, subject1 );
        printAllStudentsInSubject();


    }


    public static void addNewStudent(Student s, Map<Subject, Integer> grades) {
        mapStudentSubject.put( s, grades );
        for (Map.Entry<Subject, Integer> entry : grades.entrySet()) {
            Subject sub = entry.getKey();
            subjects.computeIfAbsent( sub, key -> new ArrayList<>() ).add( s );
        }
    }

    public static void addNewSubject(Student s, Subject sub, int grade) {
        mapStudentSubject.computeIfPresent( s, (key, val) -> mapStudentSubject.getOrDefault( s, new HashMap<>() ) ).put( sub, grade );

    }

    public static void deleteStudent(Student s) {
        Map<Subject, Integer> subjectIntegerMap = mapStudentSubject.remove( s );
        if (subjectIntegerMap == null) {
            System.out.println( "Such student doesn't exist!" );
        }
    }

    public static void printAllStudentAndGrades() {
        mapStudentSubject.forEach( (k, v) -> System.out.println( k + " " + v ) );
    }

    public static void addNewSubject(Subject sub, List<Student> students) {
        subjects.put( sub, students );
    }

    public static void addNewStudentToSubject(Student s, Subject sub) {
        subjects.computeIfPresent( sub, (k, v) -> subjects.getOrDefault( sub, new ArrayList<>() ) ).add( s );
    }

    public static void deleteStudentFromSubject(Student s, Subject sub) {
        List<Student> students = subjects.get( sub );
        if (students != null && students.contains( s )) {
            students.remove( s );
        } else {
            System.out.println( " No student or subjects exists" );
        }
    }

    public static void printAllStudentsInSubject() {
        subjects.forEach( (k, v) -> System.out.println( k + " " + v ) );
    }

}
