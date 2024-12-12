package school.faang.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private HashMap<Student, Map<Subject, Integer>> studentBySubjectAndEstimation;
    private HashMap<Subject, List<Student>> studentsBySubject;

    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();
        Subject math = new Subject(
                1, "Math"
        );
        Student studentRauan = new Student(
                1, "Rauan"
        );
        Student studentDavid = new Student(
                2, "David"
        );
        Subject ph = new Subject(
                3, "Philosophy"
        );

        studentDatabase.addStudentAndGradeBySubject(
                math, studentRauan, 98
        );

        studentDatabase.addGradeByStudents(
                studentDavid, Map.of(
                        math, 56, ph, 90
                )
        );
        System.out.println(
                "All students"
        );
        studentDatabase.printAllStudents();
        Subject cs = new Subject(
                2, "Computer Science"
        );

        List<Student> studentsForHistory = new ArrayList<>();
        studentsForHistory.add(studentDavid);
        studentsForHistory.add(studentRauan);
        studentDatabase.addStudentsBySubject(cs, studentsForHistory);
        studentDatabase.addStudentToExistingSubject(studentRauan, ph);

        System.out.println("\nAll subjects:");
        studentDatabase.printAllSubjectsAndStudents();
    }
}
