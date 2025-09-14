package school.faang.bsj2_87050;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // add new student's subject grade
        final Student student1 = new Student("student1");
        final Subject subject1 = new Subject("subject1");
        final Subject subject2 = new Subject("subject2");
        final Subject subject3 = new Subject("subject3");
        final int grade1 = 90;
        final int grade2 = 80;
        final int grade3 = 88;
        Map<Subject, Integer> subjectGrades = new HashMap<>();
        subjectGrades.put(subject1, grade1);
        subjectGrades.put(subject2, grade2);
        subjectGrades.put(subject3, grade3);
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentAndSubjectGrades(student1.getName(), subjectGrades);
        System.out.println("//1");
        System.out.println("Student Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();

        Subject subject4 = new Subject("subject4");
        studentDatabase.addStudentAndSubjectGrades(student1, subject4, 88);
        System.out.println("\n//2");
        System.out.println("\nStudent Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();

        studentDatabase.deleteStudentAndSubjects(student1);
        System.out.println("\n//3");
        System.out.println("\nStudent Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();

        Student student2 = new Student("student2");
        List<Student> students = List.of(student1, student2);
        studentDatabase.addNewSubjectAndStudents("subject5", students);
        System.out.println("\n//4");
        System.out.println("\nStudent Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();

        studentDatabase.addStudentToSubject(student1, subject1);
        studentDatabase.addStudentToSubject(student2, subject3);
        System.out.println("\n//5");
        System.out.println("\nStudent Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();

        studentDatabase.removeStudentFromSubject(student1, subject1);
        studentDatabase.removeStudentFromSubject(student1, subject2);
        studentDatabase.removeStudentFromSubject(student1, subject3);
        studentDatabase.removeStudentFromSubject(student1, subject4);
        System.out.println("//6");
        System.out.println("\nStudent Grades\n");
        studentDatabase.printAllStudentsAndSubjectGrades();
        System.out.println("\nSubject students\n");
        studentDatabase.printAllSubjectAndStudents();
    }
}
