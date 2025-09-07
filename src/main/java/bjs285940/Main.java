package bjs285940;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();

        Student ivan = new Student("Ivan Ivanov");
        Student maria = new Student("Maria Petrova");
        Student olga = new Student("Olga Sidorova");

        Subject math = new Subject("Mathematics");
        Subject physics = new Subject("Physics");
        Subject literature = new Subject("Literature");

        Map<Subject, Integer> ivanGrades = new HashMap<>();
        ivanGrades.put(math, 80);
        ivanGrades.put(physics, 75);
        database.addStudentWithSubjectAndGrade(ivan, ivanGrades);

        Map<Subject, Integer> mariaGrades = new HashMap<>();
        mariaGrades.put(literature, 95);
        mariaGrades.put(math, 90);
        database.addStudentWithSubjectAndGrade(maria, mariaGrades);

        database.addSubjectForStudent(olga, literature, 85);

        System.out.println("All subjects with their students");
        database.printAllSubjectsWithStudents();

        System.out.println("Adding subject History with Ivan and Olga");
        Subject history = new Subject("History");
        List<Student> historyStudents = Arrays.asList(ivan, olga);
        database.addSubjectWithStudents(history, historyStudents);
        database.printAllSubjectsWithStudents();

        System.out.println("Adding Maria to History");
        database.addStudentToSubject(maria, history);
        database.printAllSubjectsWithStudents();

        System.out.println("Removing Ivan from Physics");
        database.removeStudentFromSubject(ivan, physics);
        database.printAllSubjectsWithStudents();

        System.out.println("Removing Olga");
        database.removeStudent(olga);
        database.printAllSubjectsWithStudents();
    }
}