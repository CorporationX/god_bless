package school.faang.bjs2_68782.database.subject_students;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import school.faang.bjs2_68782.StudentDatabase;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static school.faang.bjs2_68782.data_set.TestData.ALL_STUDENTS;
import static school.faang.bjs2_68782.data_set.TestData.ANOTHER_STUDENTS;
import static school.faang.bjs2_68782.data_set.TestData.MUSIC;
import static school.faang.bjs2_68782.data_set.TestData.SPORT;
import static school.faang.bjs2_68782.data_set.TestData.STUDENTS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddStudentToSubjectTest {
    StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addSubjectWithStudents(SPORT, ANOTHER_STUDENTS);
    }

    @Test
    void testAddStudentToSubjectWhenStudentExistsThenAddNewSubject() {
        studentDatabase.addStudentToSubject(SPORT, STUDENTS);

        var actualSubjectStudents = studentDatabase.getSubjectStudents();
        assertEquals(ALL_STUDENTS, actualSubjectStudents.get(SPORT));
    }

    @Test
    void testAddStudentToSubjectWhenSubjectNotExistThenThrowsException() {
        assertThatThrownBy(() -> studentDatabase.addStudentToSubject(MUSIC, STUDENTS))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
