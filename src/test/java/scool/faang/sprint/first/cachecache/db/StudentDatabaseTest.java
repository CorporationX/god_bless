package scool.faang.sprint.first.cachecache.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.sprint.first.cachecache.db.StudentDatabase;

import java.util.HashSet;
import java.util.Set;

public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @Test
    public void testAddStudentWithAttr() {
        boolean addStudentResult = studentDatabase.addStudentWithAttr("Петя", "Математика", 11);
        Assertions.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addStudentWithAttr("", "Математика", 1);
        Assertions.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddSubjectForExistStudentWithScore() {
        boolean addStudentResult = studentDatabase.addSubjectForExistStudentWithScore("Математика", "Петя", 11);
        Assertions.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addSubjectForExistStudentWithScore("Математика", "", 1);
        Assertions.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddSubjectWithStudents() {
        boolean addStudentResult = studentDatabase.addSubjectWithStudents("Математика", Set.of("Петя"));
        Assertions.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addSubjectWithStudents("Математика", new HashSet<>());
        Assertions.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddStudentToExistSubject() {
        boolean addStudentResult = studentDatabase.addStudentToExistSubject("Петя", "Математика");
        Assertions.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addStudentToExistSubject("", "Математика");
        Assertions.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testRemoveStudentFromSubject() {
        studentDatabase.addStudentWithAttr("Петя", "Музыка", 1);

        Assertions.assertTrue(studentDatabase.removeStudentFromSubject("Петя", "Музыка"));
        Assertions.assertFalse(studentDatabase.removeStudentFromSubject("Вася", "Музыка"));
        Assertions.assertFalse(studentDatabase.removeStudentFromSubject("Петя", "Танцы"));
    }

    @Test
    public void testDeleteStudent() {
        studentDatabase.addStudentWithAttr("Петя", "Музыка", 1);

        Assertions.assertFalse(studentDatabase.deleteStudent("Вася"));
        Assertions.assertTrue(studentDatabase.deleteStudent("Петя"));
    }
}
