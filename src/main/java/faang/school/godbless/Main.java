package faang.school.godbless;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Deanery deanery = new Deanery();

        Student mike = new Student("Mike");
        Student jane = new Student("Jane");
        Subject math = new Subject("Math");
        Subject physics = new Subject("Computer Science");

        deanery.addStudentWithGrades(mike, Map.of(math, 90, physics, 85));
        deanery.addStudentWithGrades(jane, Map.of(math, 92));

        deanery.addSubjectToStudent(jane, physics, 88);

        deanery.addSubjectWithStudents(math, List.of(mike, jane));
        deanery.addStudentToSubject(physics, mike);

        deanery.removeStudent(mike);

        deanery.printAllStudentsWithGrades();
        deanery.printAllSubjectsWithStudents();
    }
}