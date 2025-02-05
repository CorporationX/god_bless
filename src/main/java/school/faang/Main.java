package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(new Subject("Math"), 4);
        subjects.put(new Subject("History"), 3);

        StudentDatabase studentDatabase = new StudentDatabase();
        studentDatabase.addStudentWithGrades(new Student("Anton"), subjects);
        studentDatabase.printAllSubjectsWithStudents();
        studentDatabase.removeStudentWithSubjects(new Student("Anton"));
        System.out.println("---");
        studentDatabase.printAllSubjectsWithStudents();
        studentDatabase.addSubjectForStudent(new Student("David"), new Subject("PT"), 5);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alex"));
        studentDatabase.addSubjectWithStudents(new Subject("PR"), students);
        studentDatabase.addStudentToSubject(new Student("Vitaly"), new Subject("Psychology"));
        System.out.println("---");
        studentDatabase.printAllStudentsAndSubjects();
        studentDatabase.removeStudentFromSubject(new Student("David"), new Subject("PT"));
        System.out.println("---");
        studentDatabase.printAllStudentsAndSubjects();
    }
}

