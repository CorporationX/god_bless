package scool.faang.sprint.first.cachecache.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.sprint.first.cachecache.db.StudentDatabase;

public class StudentDatabaseTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

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
