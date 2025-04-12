package school.faang.bjs2_69888;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final StudentDatabase STUDENTS_DATABASE = new StudentDatabase();
    private static Student studentNewton = new Student("Newton");
    private static Student studentDarvin = new Student("Darvin");
    private static Student studentSemikhatov = new Student("Semikhatov");
    private static Subject subjectPhisics = new Subject("Phisics");
    private static Subject subjectMath = new Subject("Math");
    private static Subject subjectGeography = new Subject("Geography");


    public static void main(String[] args) {
        Map<Subject, Integer> subjectsA = new HashMap<>();
        subjectsA.put(subjectPhisics, 5);
        subjectsA.put(subjectMath, 3);
        Map<Subject, Integer> subjectsB = new HashMap<>();
        subjectsB.put(subjectPhisics, 2);

        //        STUDENTS_DATABASE.addStudent(studentNewton, subjectsA);
        //        STUDENTS_DATABASE.addStudent(studentDarvin, subjectsB);
        //        STUDENTS_DATABASE.addSubjectForStudent(studentNewton, subjectGeography, 3);
        //        STUDENTS_DATABASE.removeStudent(studentNewton);
        STUDENTS_DATABASE.addSubjectWithStudents(subjectPhisics, List.of(studentSemikhatov, studentNewton));
        STUDENTS_DATABASE.addStudentToSubject(studentNewton, subjectMath);
        try {
            STUDENTS_DATABASE.removeStudentFromSubject(studentNewton, subjectPhisics);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + "===");
        }
        STUDENTS_DATABASE.printAllStudents();
        STUDENTS_DATABASE.printAllSubjects();
    }
}
