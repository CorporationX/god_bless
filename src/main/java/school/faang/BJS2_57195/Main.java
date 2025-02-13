package school.faang.BJS2_57195;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("Ali");
        Student studentTwo = new Student("Timur");
        Student studentThree = new Student("Baurzhan");
        Subject subjectOne = new Subject("Math");
        Subject subjectTwo = new Subject("Physic");
        Subject subjectThree = new Subject("Chemistry");

        Map<Subject, Integer> subs = new HashMap<>();
        subs.put(subjectOne, 5);
        subs.put(subjectTwo, 4);

        StudentDatabase.addStudentWithGrades(studentOne, subs);

        StudentDatabase.addSubjectForStudent(studentTwo, subjectOne, 3);

        StudentDatabase.printAllStudentsInSubjects();
        System.out.println("---------------");
        StudentDatabase.printAllSubjectsWithStudents();
        System.out.println("--------------------------------------");

        System.out.println(StudentDatabase.removeStudentFromSubject(new Student("Ali"), new Subject("Math")));
        StudentDatabase.printAllSubjectsWithStudents();
        System.out.println("----------------");
        StudentDatabase.printAllStudentsInSubjects();
    }
}
