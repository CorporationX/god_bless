package school.faang.bjs245299;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeEach
    public void setUp() {
        studentDatabase.getStudentsGrades().clear();
        studentDatabase.getSubjectStudents().clear();
    }

    @Test
    public void addNewStudentAndGradesTest() {
        StudentData data = StudentData.STUDENT1;
        studentDatabase.addNewStudentAndGrades(data.createStudent(), data.getSubjects());

        Assertions.assertEquals(1, studentDatabase.getStudentsGrades().size());
        Assertions.assertEquals(data.getSubjects().size(), studentDatabase.getSubjectStudents().size());
    }

    @Test
    public void addNewSubjectAndGradeToExistStudentTest() {
        StudentData data = StudentData.STUDENT1;
        studentDatabase.addNewStudentAndGrades(data.createStudent(), data.getSubjects());
        studentDatabase.addNewSubjectAndGradeToExistStudent();

        Assertions.assertEquals(1, studentDatabase.getStudentsGrades().size());
        Assertions.assertEquals(data.getSubjects().size(), studentDatabase.getSubjectStudents().size());
    }
}
