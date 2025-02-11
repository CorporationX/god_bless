package scool.faang.sprint.first.cachecache.db;

import org.junit.Assert;
import org.junit.Test;
import school.faang.sprint.first.cachecache.db.StudentDatabase;

import java.util.HashSet;
import java.util.Set;

public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @Test
    public void testAddStudentWithAttr() {
        boolean addStudentResult = studentDatabase.addStudentWithAttr("Петя", "Математика", 11);
        Assert.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addStudentWithAttr("", "Математика", 1);
        Assert.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddSubjectForExistStudentWithScore() {
        boolean addStudentResult = studentDatabase.addSubjectForExistStudentWithScore("Математика", "Петя", 11);
        Assert.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addSubjectForExistStudentWithScore("Математика", "", 1);
        Assert.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddSubjectWithStudents() {
        boolean addStudentResult = studentDatabase.addSubjectWithStudents("Математика", Set.of("Петя"));
        Assert.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addSubjectWithStudents("Математика", new HashSet<>());
        Assert.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testAddStudentToExistSubject() {
        boolean addStudentResult = studentDatabase.addStudentToExistSubject("Петя", "Математика");
        Assert.assertTrue(addStudentResult);

        boolean addBrokenStudentResult = studentDatabase.addStudentToExistSubject("", "Математика");
        Assert.assertFalse(addBrokenStudentResult);
    }

    @Test
    public void testRemoveStudentFromSubject() {
        studentDatabase.addStudentWithAttr("Петя", "Музыка", 1);

        Assert.assertTrue(studentDatabase.removeStudentFromSubject("Петя", "Музыка"));
        Assert.assertFalse(studentDatabase.removeStudentFromSubject("Вася", "Музыка"));
        Assert.assertFalse(studentDatabase.removeStudentFromSubject("Петя", "Танцы"));
    }

    @Test
    public void testDeleteStudent() {
        studentDatabase.addStudentWithAttr("Петя", "Музыка", 1);

        Assert.assertFalse(studentDatabase.deleteStudent("Вася"));
        Assert.assertTrue(studentDatabase.deleteStudent("Петя"));
    }
}
