import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.bjs2_68721.Student;
import school.faang.bjs2_68721.StudentDataBase;
import school.faang.bjs2_68721.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
/*
Я использовал нейросеть для тестов. Честно попытался разобраться в том, как она их пишет, и думаю,
что в следующий раз сумею написать сам.
 */

public class StudentDataBaseTest {
    private StudentDataBase database;
    private Student student1;
    private Student student2;
    private Subject subject1;
    private Subject subject2;

    @BeforeEach
    void setUp() {
        database = new StudentDataBase();

        student1 = new Student("NN");
        student2 = new Student("Marina");
        subject1 = new Subject("Mathematics");
        subject2 = new Subject("Black Magic");
    }

    @Test
    void testAddStudentWithSubject() {
        Map<Subject, Integer> subjects = new HashMap<>();
        subjects.put(subject1, 90);
        subjects.put(subject2, 85);

        database.addStudentWithSubject(student1, subjects);

        Assertions.assertEquals(subjects, database.getStudentSubjects().get(student1));
        Assertions.assertTrue(database.getSubjectStudents().get(subject1).contains(student1));
        Assertions.assertTrue(database.getSubjectStudents().get(subject2).contains(student1));
    }

    @Test
    void testAddSubjectForStudentWithGrade() {
        database.addSubjectForStudentWithGrade(subject1, student1, 95);

        Assertions.assertEquals(95, database.getStudentSubjects().get(student1).get(subject1));
        Assertions.assertTrue(database.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudentsFromBothMaps() {
        database.addSubjectForStudentWithGrade(subject1, student1, 90);
        database.removeStudentsFromBothMaps(student1);

        Assertions.assertFalse(database.getStudentSubjects().containsKey(student1));
        Assertions.assertFalse(database.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testRemoveStudentsFromBothMapsThrowsWhenNotFound() {
        Assertions.assertThrows(NoSuchElementException.class,
                () -> database.removeStudentsFromBothMaps(student1));
    }

    @Test
    void testAddSubjectWithStudents() {
        database.setStudentSubjects(new HashMap<>());
        database.setSubjectStudents(new HashMap<>());

        List<Student> students = List.of(student1, student2);
        database.addSubjectWithStudents(subject1, students);


        Assertions.assertEquals(students, database.getSubjectStudents().get(subject1));
        Assertions.assertTrue(database.getStudentSubjects().get(student1).containsKey(subject1));
        Assertions.assertNull(database.getStudentSubjects().get(student1).get(subject1));
    }

    @Test
    void testAddStudentToSubject() {
        database.getStudentSubjects().put(student1, new HashMap<>());
        database.getSubjectStudents().put(subject1, new ArrayList<>());
        database.addStudentToSubject(student1, subject1);

        Assertions.assertTrue(database.getSubjectStudents().get(subject1).contains(student1));
        Assertions.assertTrue(database.getStudentSubjects().get(student1).containsKey(subject1));
        Assertions.assertNull(database.getStudentSubjects().get(student1).get(subject1));
    }

    @Test
    void testAddStudentToSubjectWhenNotInMaps() {
        database.addStudentToSubject(student1, subject1);

        Assertions.assertFalse(database.getStudentSubjects().containsKey(student1));
        Assertions.assertFalse(database.getSubjectStudents().containsKey(subject1));
    }

    @Test
    void testRemoveStudentFromSubject() {
        database.addSubjectForStudentWithGrade(subject1, student1, 90);
        database.removeStudentFromSubject(student1, subject1);

        Assertions.assertFalse(database.getStudentSubjects().get(student1).containsKey(subject1));
        Assertions.assertFalse(database.getSubjectStudents().get(subject1).contains(student1));
    }

    @Test
    void testPrintStudentInfo() {
        database.addSubjectForStudentWithGrade(subject1, student1, 90);
        database.addSubjectForStudentWithGrade(subject2, student1, 85);

        Assertions.assertDoesNotThrow(() -> database.printStudentInfo());
    }
}
