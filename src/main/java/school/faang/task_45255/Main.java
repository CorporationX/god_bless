package school.faang.task_45255;

import school.faang.task_45255.entity.Student;
import school.faang.task_45255.entity.Subject;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        Subject math = new Subject("Math");
        Subject science = new Subject("Science");
        Subject history = new Subject("History");

        Student student1 = new Student("John Doe");
        Student student2 = new Student("Jane Smith");
        Student student3 = new Student("Alice Brown");

        try {
            studentDatabase.addStudents(student1, math, 5);
            studentDatabase.addStudents(student1, science, 4);
            studentDatabase.addStudents(student2, math, 3);
            studentDatabase.addStudents(student3, history, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== All Students ===");
        studentDatabase.printStudents();

        try {
            studentDatabase.addSubjects(math, student1);
            studentDatabase.addSubjects(science, student2);
            studentDatabase.addSubjects(history, student3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== All Subjects and Students ===");
        studentDatabase.printSubjects();


        try {
            studentDatabase.removeStudents(student2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== All Students after remove ===");
        studentDatabase.printStudents();

        try {
            studentDatabase.removeSubjects(science);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== All Subjects after remove ===");
        studentDatabase.printSubjects();
    }
}

