package school.faang.bjs2_79756;

import java.util.HashMap;
import java.util.Map;

public class Students {
    public static void main(String[] args) {
        final StudentDatabase studentDatabase = new StudentDatabase();

        final Student john = new Student("John");
        final Student mary = new Student("Mary");
        final Student nicholas = new Student("Nicholas");

        final Subject math = new Subject("Math");
        final Subject gym = new Subject("Gym");
        final Subject english = new Subject("English");

        Map<Subject, Integer> johnSubjects = new HashMap<>();
        johnSubjects.put(math, 2);
        johnSubjects.put(gym, 3);

        Map<Subject, Integer> marySubjects = new HashMap<>();
        marySubjects.put(math, 5);
        marySubjects.put(english, 4);

        Map<Subject, Integer> nicholasSubjects = new HashMap<>();
        nicholasSubjects.put(gym, 5);
        nicholasSubjects.put(english, 5);

        studentDatabase.addStudentWithGrades(john, johnSubjects);
        studentDatabase.addStudentWithGrades(mary, marySubjects);
        studentDatabase.addStudentWithGrades(nicholas, nicholasSubjects);

        studentDatabase.printStudentsWithGrades();

        studentDatabase.removeStudentWithSubject(john);

        studentDatabase.addSubjectForStudentWithGrade(nicholas, math, 5);
        System.out.println("---------------------------");

        studentDatabase.printSubjectsWithStudents();
    }
}