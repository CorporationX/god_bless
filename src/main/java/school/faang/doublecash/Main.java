package school.faang.doublecash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addNewStudent(new Student("Rick"),
                new HashMap<>(Map.of(new Subject("Math"), 5, new Subject("English"), 3)));
        studentDatabase.addNewStudent(new Student("Mark"),
                new HashMap<>(Map.of(new Subject("English"), 4, new Subject("Deutsch"), 5)));
        studentDatabase.addNewStudent(new Student("Elsa"),
                new HashMap<>(Map.of(new Subject("English"), 3, new Subject("Math"), 5, new Subject("Fisick"), 2)));
        studentDatabase.addNewStudent(new Student("Sub"),
                new HashMap<>(Map.of(new Subject("English"), 4)));

        studentDatabase.addNewSubjectForStudent(new Student("Rick"), new Subject("Sport"), 5);

        studentDatabase.removeStudent(new Student("Sub"));
        studentDatabase.printAllSubjectsWithStudents();

        studentDatabase.addNewSubjectsWithStudents(new Subject("History"),
                new ArrayList<>(List.of(new Student("Karl"), new Student("Elsa"), new Student("Enakin"))));

        studentDatabase.addStudentToSubject(new Student("Karl"), new Subject("Math"));
        studentDatabase.removeStudentFromSubject(new Student("Rick"), new Subject("English"));

        studentDatabase.printAllSubjectsAndStudent();
    }
}
