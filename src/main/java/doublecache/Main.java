package doublecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static doublecache.StudentSubjectService.addStudentWithGradesAndSubjects;
import static doublecache.StudentSubjectService.addSubjectWithStudents;
import static doublecache.StudentSubjectService.printAllStudentsWithGrades;
import static doublecache.StudentSubjectService.printAllSubjectWithStudents;
import static doublecache.StudentSubjectService.removeStudent;
import static doublecache.StudentSubjectService.removeStudentFromSubject;

public class Main {
    public static void main(String[] args) {
        Map<Subject, Integer> testSubjectsAndGrades = new HashMap<>();
        testSubjectsAndGrades.put(new Subject(1, "subject1"), 1);
        testSubjectsAndGrades.put(new Subject(2, "subject2"), 3);
        testSubjectsAndGrades.put(new Subject(3, "subject3"), 4);

        addStudentWithGradesAndSubjects(new Student(1, "student1"), testSubjectsAndGrades);
        addStudentWithGradesAndSubjects(new Student(1, "student1"), testSubjectsAndGrades);
        addStudentWithGradesAndSubjects(new Student(2, "student2"), testSubjectsAndGrades);
        addStudentWithGradesAndSubjects(new Student(3, "student3"), testSubjectsAndGrades);

        printAllStudentsWithGrades();
        printAllSubjectWithStudents();

        System.out.println();

        removeStudent(new Student(2, "student2"));
        printAllStudentsWithGrades();
        printAllSubjectWithStudents();

        System.out.println();

        List<Student> students = new ArrayList<>();
        students.add(new Student(4, "student4"));
        students.add(new Student(5, "student5"));
        students.add(new Student(6, "student6"));
        students.add(new Student(7, "student7"));
        addSubjectWithStudents(new Subject(4, "subject4"), students);
        printAllStudentsWithGrades();
        printAllSubjectWithStudents();

        System.out.println();

        removeStudentFromSubject(new Student(7, "student7"), new Subject(4, "subject4"));
        printAllStudentsWithGrades();
        printAllSubjectWithStudents();
    }
}