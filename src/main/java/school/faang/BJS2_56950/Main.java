package school.faang.BJS2_56950;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final String RAMIL = "Ramil";
    private static final String ALBERT = "Albert";
    private static final String KAMIL = "Kamil";
    private static final String MATH = "Math";
    private static final String ART = "Art";

    public static void main(String[] args) {
        System.out.printf("Работа с переменной studentSubjects ");
        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.addStudentAndSubjectWithInteger(RAMIL, MATH, 3);
        studentDatabase.addStudentAndSubjectWithInteger(ALBERT, MATH, 5);
        studentDatabase.showStudentWithSubject();
        studentDatabase.addNewSubjectWithInteger(RAMIL, ART, 2);
        studentDatabase.addNewSubjectWithInteger(ALBERT, ART, 5);
        studentDatabase.showStudentWithSubject();
        studentDatabase.deleteStudent(RAMIL);
        studentDatabase.showStudentWithSubject();

        System.out.printf("%nРабота с переменной subjectStudents");
        studentDatabase.addNewSubjectWithStudents(new HashSet<>(Set.of(RAMIL, ALBERT)), MATH);
        studentDatabase.showSubjectWithStudent();
        studentDatabase.addNewStudentForSubject(KAMIL, MATH);
        studentDatabase.showSubjectWithStudent();
        studentDatabase.deleteStudentFromSubject(ALBERT, MATH);
        studentDatabase.showSubjectWithStudent();
    }
}
