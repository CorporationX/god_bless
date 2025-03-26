package school.faang.BJS2_56950;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    private static final String RAMIL = "Ramil";
    private static final String ALBERT = "Albert";
    private static final String KAMIL = "Kamil";
    private static final String MATH = "Math";
    private static final String ART = "Art";
    private static final String PHYSICS = "Physics";

    private static final Student STUDENT_RAM = new Student(RAMIL);
    private static final Student STUDENT_ALB = new Student(ALBERT);
    private static final Subject SUBJECT_MATH = new Subject(MATH);
    private static final Subject SUBJECT_ART = new Subject(ART);
    private static final Subject SUBJECT_PHYSICS = new Subject(PHYSICS);

    public static void main(String[] args) {

        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 2);
        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_ALB, SUBJECT_MATH, 5);
        studentDatabase.showStudentWithSubject();

        studentDatabase.addNewSubjectWithInteger(STUDENT_RAM, SUBJECT_ART, 2);
        studentDatabase.addNewSubjectWithInteger(STUDENT_ALB, SUBJECT_ART, 5);
        studentDatabase.showStudentWithSubject();

        studentDatabase.deleteStudent(STUDENT_RAM);
        studentDatabase.showStudentWithSubject();

        studentDatabase.addStudentAndSubjectWithInteger(STUDENT_RAM, SUBJECT_MATH, 2);
        studentDatabase.showStudentWithSubject();

        studentDatabase.addNewSubjectWithStudents(new ArrayList<>(List.of(STUDENT_RAM, STUDENT_ALB)), SUBJECT_PHYSICS);
        studentDatabase.showSubjectWithStudent();
        studentDatabase.addNewStudentForSubject(STUDENT_RAM, SUBJECT_ART, 5);
        studentDatabase.showSubjectWithStudent();
        studentDatabase.deleteStudentFromSubject(STUDENT_ALB, SUBJECT_MATH);
        studentDatabase.showSubjectWithStudent();
    }
}
