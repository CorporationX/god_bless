package gratsio_BJS2_68733;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDataBase dataBase = new StudentDataBase();

        Student student1 = new Student("Alex");
        Student student2 = new Student("Fred");
        Student student3 = new Student("John");
        Student student4 = new Student("Jane");
        Student student5 = new Student("Mary");
        List<Student> students = List.of(student3, student4, student5);

        Subject sub1 = new Subject("Math");
        Subject sub2 = new Subject("Literature");
        Subject sub3 = new Subject("History");
        Subject sub4 = new Subject("Chemistry");
        Subject sub5 = new Subject("Russian Language");
        Subject sub6 = new Subject("Physics");

        Map<Subject, Integer> GradesOfSubOfStudent1 = new HashMap<>();
        GradesOfSubOfStudent1.put(sub1, 5);
        Map<Subject, Integer> GradesOfSubOfStudent2 = new HashMap<>();
        GradesOfSubOfStudent2.put(sub1, 3);

        dataBase.addStudentWithSubjectsAndGrades(student1, GradesOfSubOfStudent1);
        dataBase.addStudentWithSubjectsAndGrades(student2, GradesOfSubOfStudent2);

        dataBase.addSubjectAndGradesForStudent(student1, sub2, 4);
        dataBase.addSubjectAndGradesForStudent(student1, sub5, 3);
        dataBase.addSubjectAndGradesForStudent(student2, sub2, 4);
        dataBase.addSubjectAndGradesForStudent(student2, sub3, 5);
        dataBase.addSubjectAndGradesForStudent(student2, sub4, 3);

        dataBase.printAllStudents();
        dataBase.deleteStudentWithSubjectsAndGrades(student1);

        dataBase.addSubjectAndListOfStudents(sub6, students);
        dataBase.printAllStudents();

        dataBase.addStudentToSubject(student4, sub1);
        dataBase.printAllStudents();

        dataBase.printAllSubjects();
    }
}
