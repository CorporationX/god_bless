package school.faang.cachecache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create instances of StudentDatabase
        StudentDatabase studentDatabase = new StudentDatabase();

        // Create students
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Student student3 = new Student(3, "Charlie");

        // Create subjects
        Subject math = new Subject(101, "Mathematics");
        Subject physics = new Subject(102, "Physics");
        Subject literature = new Subject(103, "Literature");

        // Add student with subjects and grades
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 85);
        aliceGrades.put(physics, 90);
        studentDatabase.addStudentWithGrades(student1, aliceGrades);

        // Add a new subject for an existing student
        studentDatabase.addSubjectForStudent(student1, literature, 78);

        // Add subjects and students directly
        List<Student> physicsStudents = new ArrayList<>();
        physicsStudents.add(student1);
        physicsStudents.add(student2);
        studentDatabase.addSubjectWithStudents(physics, physicsStudents);

        // Print all students and their grades
        System.out.println("All Students and their Grades:");
        studentDatabase.printAllStudentsAndGrades();

        // Print all subjects and the students studying them
        System.out.println("\nAll Subjects and Students:");
        studentDatabase.printAllSubjectsAndStudents();

        // Remove a student from a subject
        studentDatabase.removeStudentFromSubject(physics, student2);

        // Remove a student completely
        studentDatabase.removeStudent(student1);

        // Final printout
        System.out.println("\nFinal Data:");
        studentDatabase.printAllStudentsAndGrades();
        studentDatabase.printAllSubjectsAndStudents();
    }
}
