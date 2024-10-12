package Java_HashMap.BJS2_32512;

import Java_HashMap.BJS2_32512.Exception.StudentAlreadyExistsException;
import Java_HashMap.BJS2_32512.Exception.StudentNotFoundException;
import Java_HashMap.BJS2_32512.Manager.StudentManager;
import Java_HashMap.BJS2_32512.Manager.SubjectManager;

import java.util.*;

public class Main {

    private static Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
    private static Map<Subject, List<Student>> subjectStudents = new HashMap<>();

    public static void main(String[] args) {
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");

        Subject math = new Subject(1, "Math");
        Subject physics = new Subject(2, "Physics");
        Subject chemistry = new Subject(3, "Chemistry");

        try {
            Map<Subject, Integer> grades = new HashMap<>();
            grades.put(math, 85);
            grades.put(physics, 75);
            StudentManager.addNewStudent(studentGrades, student1, grades);


            List<Student> mathStudents = Arrays.asList(student1);
            List<Student> physicsStudents = Arrays.asList(student2);

            SubjectManager.addNewSubjectAndStudents(subjectStudents, math, mathStudents);
            SubjectManager.addNewSubjectAndStudents(subjectStudents, math, physicsStudents);

            StudentManager.printAllStudents(studentGrades);
            SubjectManager.printAllSubjects(subjectStudents);

        } catch (StudentAlreadyExistsException  e) {
            System.out.println(e.getMessage());
        }
    }
}
