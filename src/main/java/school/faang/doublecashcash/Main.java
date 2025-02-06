package school.faang.doublecashcash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            StudentDatabase studentDatabase = new StudentDatabase();

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            Map<Subject, Integer> subjects = new HashMap<>();

            subjects.put(new Subject("Computer science"), 5);
            subjects.put(new Subject("Math"), 5);
            subjects.put(new Subject("English language"), 4);

            List<Student> students = new ArrayList<>();

            students.add(new Student("Max"));
            students.add(new Student("Andrey"));

            studentDatabase.addStudent("Angelina", subjects);
            studentDatabase.addSubject("Chemistry", students);
            studentDatabase.addStudent("Max", subjects);
            studentDatabase.addSubject("Computer science", students);
            studentDatabase.addSubject("Computer science", students);
            studentDatabase.addStudent("Max", subjects);
            studentDatabase.addSubject("Chemistry", students);
            studentDatabase.addStudent("Angelina", subjects);

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            studentDatabase.deleteStudentAndHisSubjects("Max");
            studentDatabase.deleteStudentAndHisSubjects("Max");
            studentDatabase.deleteStudentFromSubjects("Math", "Andrey");
            studentDatabase.deleteStudentFromSubjects("Math", "Max");

            studentDatabase.deleteStudentFromSubjects("Computer science", "Angelina");

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            studentDatabase.addSubjectForStudent("Max", "Chemistry", 5);
            studentDatabase.addSubjectForStudent("Max", "Chemistry", 4);
            studentDatabase.addSubjectForStudent("Max", "Russian language", 5);
            studentDatabase.addSubjectForStudent("Anton", "Music", 3);

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            studentDatabase.addStudentForSubject("Computer science", "Angelina");
            studentDatabase.addStudentForSubject("Computer science", "Angelina");
            studentDatabase.addStudentForSubject("Russian language", "Max");
            studentDatabase.addStudentForSubject("Physical culture", "Oleg");
            studentDatabase.addStudentForSubject("Physics", "Oleg");
            studentDatabase.addStudentForSubject("Physical culture", "Kate");

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            studentDatabase.addStudent("Nick", subjects);
            studentDatabase.addSubject("Economy", students);
            studentDatabase.addStudent("Max", subjects);
            studentDatabase.addSubject("Math", students);

            studentDatabase.printAllStudentSubjects();
            studentDatabase.printAllSubjectStudents();

            List<Student> emptyStudentsList = new ArrayList<>();
            studentDatabase.addSubject("Math", emptyStudentsList);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
