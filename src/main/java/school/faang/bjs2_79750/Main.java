package school.faang.bjs2_79750;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        Student student = new Student("Edward");
        Map<Subject, Integer> subjectsWithGrades = new HashMap<>(Map.of(
                new Subject("Math"), 4,
                new Subject("English"), 5));
        Student student2 = new Student("Alex");
        Map<Subject, Integer> subjectsWithGrades2 = new HashMap<>(Map.of(
                new Subject("Math"), 4,
                new Subject("English"), 5));
        studentDatabase.addStudentAndSubjectsWithGrades(student, subjectsWithGrades);
        studentDatabase.addStudentAndSubjectsWithGrades(student2, subjectsWithGrades2);

        studentDatabase.printAllStudents();
        studentDatabase.printAllSubjectsWithStudents();
    }
}
