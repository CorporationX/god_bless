package school.faang.task_57157;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        StudentDatabase studentDatabase = new StudentDatabase();

        Student studentAlex = new Student("Alex");

        Student studentOlga = new Student("Olga");

        Student studentOleg = new Student("Oleg");

        Subject math = new Subject("Math");
        Subject history = new Subject("History");
        Subject biology = new Subject("Biology");
        Subject english = new Subject("English");
        Subject it = new Subject("it");

        Map<Subject, Integer> subjectAlex = new HashMap<>();
        Map<Subject, Integer> subjectOlga = new HashMap<>();
        Map<Subject, Integer> subjectOleg = new HashMap<>();

        subjectAlex.put(math, random.nextInt(5));
        subjectAlex.put(history, random.nextInt(5));
        subjectAlex.put(english, random.nextInt(5));
        subjectOlga.put(english, random.nextInt(5));
        subjectOlga.put(biology, random.nextInt(5));
        subjectOlga.put(history, random.nextInt(5));
        subjectOleg.put(history, random.nextInt(5));

        studentDatabase.addStudentWithGrades(studentAlex, subjectAlex);
        studentDatabase.addStudentWithGrades(studentAlex, subjectOlga);
        studentDatabase.addStudentWithGrades(studentAlex, subjectOleg);
        studentDatabase.addSubjectForStudent(english, studentOleg, random.nextInt(5));
        studentDatabase.printAllSubjectsWithStudentsAndGrade();
        studentDatabase.removeStudent(studentAlex);
        List<Student> studentList = new ArrayList<>();
        studentList.add(studentOlga);
        studentList.add(studentOleg);
        studentDatabase.addSubjectWithStudents(it, studentList);
        studentDatabase.removeStudentFromSubject(studentOlga, it);
        studentDatabase.printAllSubjectsWithStudents();
    }
}
