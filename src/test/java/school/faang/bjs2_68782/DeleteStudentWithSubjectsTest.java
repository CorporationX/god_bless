package school.faang.bjs2_68782;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bjs2_68782.data_set.TestData.ALL_SUBJECTS_WITH_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.SOME_SUBJECTS_WITH_CHANGED_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT1;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT2;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT3;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeleteStudentWithSubjectsTest {
    StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT1, ALL_SUBJECTS_WITH_GRADES);
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT2, SOME_SUBJECTS_WITH_CHANGED_GRADES);
    }

    @Test
    void testDeleteStudentWithSubjectsWhenStudentExists() {
        var studentSubjectsBeforeDelete = studentDatabase.getStudentSubjects();
        assertTrue(studentSubjectsBeforeDelete.containsKey(STUDENT1));

        studentDatabase.deleteStudentWithSubjects(STUDENT1);

        var studentSubjectsAfterDelete = studentDatabase.getStudentSubjects();
        assertFalse(studentSubjectsAfterDelete.containsKey(STUDENT1));
    }

    @Test
    void testDeleteStudentWithSubjectsWhenStudentNotExistsThenDoNothing() {
        Assertions.assertThatThrownBy(() -> studentDatabase.deleteStudentWithSubjects(STUDENT3))
                .isInstanceOf(NoSuchElementException.class);
    }
}
