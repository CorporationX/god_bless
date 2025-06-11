package school.faang.bjs2_79750;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        Student studentEdward = new Student("Edward");
        Map<Subject, Integer> subjectsWithGrades = new HashMap<>(Map.of(
                new Subject("Math"), 4,
                new Subject("English"), 5));
        Student studentAlex = new Student("Alex");
        Map<Subject, Integer> subjectsWithGrades2 = new HashMap<>(Map.of(
                new Subject("Math"), 4,
                new Subject("English"), 5));
        studentDatabase.addStudentAndSubjectsWithGrades(studentEdward, subjectsWithGrades);
        studentDatabase.addStudentAndSubjectsWithGrades(studentAlex, subjectsWithGrades2);

        studentDatabase.printAllStudents();
        studentDatabase.printAllSubjectsWithStudents();
    }
}
