package school.faang.task_45229;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<Subject, Integer> firstStudentGrades = new HashMap<>();
        firstStudentGrades.put(new Subject("Mathematics"), 5);
        firstStudentGrades.put(new Subject("Physics"), 8);
        firstStudentGrades.put(new Subject("Chemistry"), 4);
        Student firstStudent = new Student("Bob");

        UniversityDatabase universityDatabase = new UniversityDatabase();
        universityDatabase.addStudentAndGrades(firstStudent, firstStudentGrades);

        HashMap<Subject, Integer> secondStudentGrades = new HashMap<>();
        secondStudentGrades.put(new Subject("Mathematics"), 5);
        secondStudentGrades.put(new Subject("English"), 7);
        secondStudentGrades.put(new Subject("Chemistry"), 6);
        Student secondStudent = new Student("Rik");

        universityDatabase.addStudentAndGrades(secondStudent, secondStudentGrades);

        universityDatabase.printAllSubjects();
        universityDatabase.printStudentsWithGrades();

        universityDatabase.removeSubject(new Subject("Mathematics"));

        universityDatabase.printAllSubjects();
        universityDatabase.printStudentsWithGrades();
    }
}
