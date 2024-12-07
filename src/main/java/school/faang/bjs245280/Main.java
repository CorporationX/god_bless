package school.faang.bjs245280;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final Map<Student, Map<Subject, Integer>> subjectGradleByStudent = new HashMap<>();
    private static final Map<Subject, List<Student>> studentBySubject = new HashMap<>();

    public static void main(String[] args) {

        StudentDatabase studentDatabase;
        studentDatabase = new StudentDatabase(subjectGradleByStudent, studentBySubject);
        Student tom = studentDatabase.addStudent("Tom");
        Student bob = studentDatabase.addStudent("Bob");

        Subject mathematics = studentDatabase.addSubject("mathematics");
        Subject informatics = studentDatabase.addSubject("informatics");

        Map<Subject, Integer> subjectGradeToms = new HashMap<>();
        subjectGradeToms.put(mathematics, 5);
        subjectGradeToms.put(informatics, 3);

        studentDatabase.addStudentSubjectGrades(tom, subjectGradeToms);
        studentDatabase.addStudentSubjectGrades(bob, subjectGradeToms);

        studentDatabase.addSubjectForStudent("psychology", tom, 4);
        studentDatabase.printStudentSubjectGrade();

        System.out.println("----------------------------");

        studentDatabase.deleteStudentSubject(getStudentByName("Bob"));
        studentDatabase.printStudentSubject();
    }

    private static Student getStudentByName(String nameStudent) {
        return subjectGradleByStudent.keySet().stream()
                .filter(v-> v.getName().equals(nameStudent))
                .findFirst().orElse(null);
    }

}
