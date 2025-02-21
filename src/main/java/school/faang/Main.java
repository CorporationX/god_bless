package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Subject history = new Subject("History");
        Subject italian = new Subject("Italian");
        StudentDatabase.printAllStudentsAndTheirMarksBySubject();
        Student alexSkvortsov = new Student("Alex Skvortsov");
        Map<Subject, Integer> subjectsWithMarksForAlex = new HashMap<>();
        subjectsWithMarksForAlex.put(history, 5);
        subjectsWithMarksForAlex.put(italian, 5);
        StudentDatabase.addNewStudentWithHisSubjectsWithMarks(alexSkvortsov, subjectsWithMarksForAlex);
        StudentDatabase.printAllStudentsAndTheirMarksBySubject();
        Subject math = new Subject("Math");
        StudentDatabase.addNewSubjectToTheExistingStudent(alexSkvortsov, math);
        StudentDatabase.printAllStudentsAndTheirMarksBySubject();
        StudentDatabase.removeStudentWithHisSubjects(alexSkvortsov);
        StudentDatabase.printAllStudentsAndTheirMarksBySubject();
        Subject literature = new Subject("Literature");
        Student pavelJades = new Student("Pavel Jades");
        Student valyaPushkin = new Student("Valya Pushkin");
        StudentDatabase.addSubjectWithStudents(literature, new ArrayList<>(Arrays.asList(pavelJades, valyaPushkin)));
        StudentDatabase.printAllStudentsAndTheirMarksBySubject();
    }
}
