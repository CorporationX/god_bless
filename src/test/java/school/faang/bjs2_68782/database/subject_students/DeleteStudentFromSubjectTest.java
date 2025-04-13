package school.faang.bjs2_68782.database.subject_students;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import school.faang.bjs2_68782.StudentDatabase;

import java.util.NoSuchElementException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bjs2_68782.data_set.TestData.ANOTHER_STUDENTS;
import static school.faang.bjs2_68782.data_set.TestData.MATHEMATICS;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT1;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT2;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeleteStudentFromSubjectTest {
    StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addSubjectWithStudents(MATHEMATICS, ANOTHER_STUDENTS);
    }

    @Test
    void testDeleteStudentFromSubjectWhenSubjectAndStudentExists() {
        assertTrue(studentDatabase.getSubjectStudents().get(MATHEMATICS)
                .contains(STUDENT1));
        studentDatabase.deleteStudentFromSubject(MATHEMATICS, STUDENT1);

        var actualSubjectStudents = studentDatabase.getSubjectStudents();
        assertFalse(actualSubjectStudents.get(MATHEMATICS)
                .contains(STUDENT1));
    }

    @Test
    void testDeleteStudentFromSubjectWhenStudentNotExistsThenThrowsException() {
        assertThatThrownBy(() -> studentDatabase.deleteStudentFromSubject(MATHEMATICS, STUDENT2))
                .isInstanceOf(NoSuchElementException.class);
    }
}
