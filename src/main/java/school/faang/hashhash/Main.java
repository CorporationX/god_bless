package school.faang.hashhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("English");
        Map<Subject, Integer> mapSubject = new HashMap<>();
        mapSubject.put(subject1, 5);
        mapSubject.put(subject2, 4);
        Map<Subject, Integer> mapSubject2 = new HashMap<>();
        mapSubject2.put(subject1, 4);
        mapSubject2.put(subject2, 3);
        Map<Subject, Integer> mapSubject3 = new HashMap<>();
        mapSubject3.put(subject1, 2);
        mapSubject3.put(subject2, 4);
        StudentDatabase studentDatabase = new StudentDatabase();
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Pety");
        Student student3 = new Student("Zaur");
        studentDatabase.addStudentWithSubject(student1, mapSubject);
        studentDatabase.addStudentWithSubject(student2, mapSubject2);
        studentDatabase.addStudentWithSubject(student3, mapSubject3);
        System.out.println("Print after add student:\n");
        studentDatabase.printAllStudentWithSubject();

        Subject subject4 = new Subject("Chemistry");
        studentDatabase.addSubjectForStudent(subject4, student1, 4);
        System.out.println("Print after add subject to student:\n");
        studentDatabase.printAllStudentWithSubject();

        System.out.println("Print after remove student:\n");
        studentDatabase.removeStudent(student1);
        studentDatabase.printAllStudentWithSubject();

        System.out.println("Print after add subject from students:\n");
        Subject newSubject = new Subject("Physics");
        List<Student> addStudents = new ArrayList<>();
        addStudents.add(student1);
        addStudents.add(student2);
        studentDatabase.addSubject(addStudents, newSubject);
        studentDatabase.printAllSubjectWithStudents();

        System.out.println("Print after add student from subjects:\n");
        Student student5 = new Student("VladIsLove");
        studentDatabase.addStudentForSubject(student5, newSubject);
        studentDatabase.printAllSubjectWithStudents();

        System.out.println("Print after remove student:\n");
        studentDatabase.removeStudentForSubject(student5, newSubject);
        studentDatabase.printAllSubjectWithStudents();


    }
}
