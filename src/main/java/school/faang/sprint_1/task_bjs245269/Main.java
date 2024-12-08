package school.faang.sprint_1.task_bjs245269;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StudentDatabase database = initializeDatabase();

        testAddStudentWithGrades(database);
        testAddSubjectForStudent(database);
        testRemoveStudent(database);
        testAddSubjectWithStudents(database);
        testAddStudentToSubject(database);
        testDeleteStudentFromSubject(database);
        testPrintAllSubjectsWithStudents(database);
    }

    private static StudentDatabase initializeDatabase() {
        Subject math = new Subject(1, "Math");
        Subject science = new Subject(2, "Science");
        Map<Subject, Integer> aliceGrades = new HashMap<>();
        aliceGrades.put(math, 85);
        aliceGrades.put(science, 90);
        Map<Subject, Integer> bobGrades = new HashMap<>();
        bobGrades.put(math, 78);

        StudentDatabase database = new StudentDatabase();
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        database.addStudentWithGrades(student1, aliceGrades);
        database.addStudentWithGrades(student2, bobGrades);
        return database;
    }

    private static void testAddStudentWithGrades(StudentDatabase database) {
        System.out.println("---");
        Student student = new Student(3, "Charlie");
        Subject physics = new Subject(3, "Physics");
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(physics, 95);
        database.addStudentWithGrades(student, grades);
        database.printAllStudentsWithGrades();
    }

    private static void testAddSubjectForStudent(StudentDatabase database) {
        System.out.println("---");
        Student student = new Student(1, "Alice");
        Subject history = new Subject(4, "History");
        database.addSubjectForStudent(student, history, 88);
    }

    private static void testRemoveStudent(StudentDatabase database) {
        System.out.println("---");
        Student student = new Student(2, "Bob");
        database.removeStudent(student);
    }

    private static void testAddSubjectWithStudents(StudentDatabase database) {
        System.out.println("---");
        Subject geography = new Subject(5, "Geography");
        Student student1 = new Student(1, "Alice");
        Student student3 = new Student(3, "Charlie");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student3);

        database.addSubjectWithStudents(geography, list);
    }

    private static void testAddStudentToSubject(StudentDatabase database) {
        System.out.println("---");
        Subject chemistry = new Subject(6, "Chemistry");
        Student student = new Student(3, "Charlie");
        database.addStudentToSubject(student, chemistry);
    }

    private static void testDeleteStudentFromSubject(StudentDatabase database) {
        System.out.println("---");
        Subject geography = new Subject(5, "Geography");
        Student student = new Student(1, "Alice");
        database.deleteStudentFromSubject(student, geography);
    }

    private static void testPrintAllSubjectsWithStudents(StudentDatabase database) {
        System.out.println("---");
        database.printAllSubjectsWithStudents();
    }
}
