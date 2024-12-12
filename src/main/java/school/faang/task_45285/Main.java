package school.faang.task_45285;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        Subject math = new Subject(1, "Mathematics");
        Subject physics = new Subject(2, "Physics");

        database.addStudent(student1, Map.of(math, 90, physics, 85));
        database.addStudent(student2, Map.of(math, 75));

        database.printAllStudentsAndGrades();

        database.addSubjectToStudent(student2, physics, 80);

        database.removeStudent(student1);

        database.printAllSubjectsAndStudents();
    }
}
