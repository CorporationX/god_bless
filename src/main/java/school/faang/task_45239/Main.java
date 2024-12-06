package school.faang.task_45239;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        Student s1 = new Student(1, "Ivan Ivanov");
        Student s2 = new Student(2, "Maria Petrova");
        Student s3 = new Student(3, "Alexey Smirnov");

        Subject math = new Subject(1, "Mathematics");
        Subject physics = new Subject(2, "Physics");

        database.addStudentWithGrades(s1, new HashMap<>(Map.of(math, 95, physics, 90)));
        database.addStudentWithGrades(s2, new HashMap<>(Map.of(math, 75, physics, 65)));
        database.addStudentWithGrades(s3, new HashMap<>(Map.of(math, 55, physics, 40)));

        Subject informatics = new Subject(3, "Informatics");
        database.addSubjectForStudent(s1, informatics, 100);

        Subject chemistry = new Subject(4, "Chemistry");
        database.addSubjectWithStudents(chemistry, new ArrayList<>(List.of(s1, s2, s3)));

        database.removeStudentFromSubject(s1, physics);

        database.removeStudent(s3);

        System.out.println("List of students and their grades:");
        database.printAllStudentsWithGrades();

        System.out.println("\nList of subjects and students:");
        database.printAllSubjectsWithStudents();
    }
}