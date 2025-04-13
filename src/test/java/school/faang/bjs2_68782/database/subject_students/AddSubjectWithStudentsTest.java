package school.faang.bjs2_68782.database.subject_students;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import school.faang.bjs2_68782.StudentDatabase;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bjs2_68782.data_set.TestData.ANOTHER_STUDENTS;
import static school.faang.bjs2_68782.data_set.TestData.EMPTY_LIST_OF_STUDENTS;
import static school.faang.bjs2_68782.data_set.TestData.MATHEMATICS;
import static school.faang.bjs2_68782.data_set.TestData.MUSIC;
import static school.faang.bjs2_68782.data_set.TestData.SPORT;
import static school.faang.bjs2_68782.data_set.TestData.STUDENTS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddSubjectWithStudentsTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addSubjectWithStudents(SPORT, ANOTHER_STUDENTS);
    }

    @Test
    void testAddSubjectWithStudentsWhenNewSubjectAndStudentsThenAddedToDatabase() {
        studentDatabase.addSubjectWithStudents(MATHEMATICS, STUDENTS);

        var actualSubjectStudents = studentDatabase.getSubjectStudents();
        assertTrue(actualSubjectStudents.containsKey(MATHEMATICS));
        Assertions.assertThat(actualSubjectStudents.get(MATHEMATICS)).containsExactlyInAnyOrderElementsOf(STUDENTS);
    }

    @Test
    void testAddSubjectWithStudentsWhenExistingSubjectThenDoNotAdd() {
        Assertions.assertThatThrownBy(() -> studentDatabase.addSubjectWithStudents(SPORT, STUDENTS))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testAddSubjectWithStudentsWhenEmptyStudentsThenAddSubjectWoStudents() {
        studentDatabase.addSubjectWithStudents(MUSIC, EMPTY_LIST_OF_STUDENTS);

        var actualSubjectStudents = studentDatabase.getSubjectStudents();
        assertTrue(actualSubjectStudents.containsKey(MUSIC));
        assertEquals(Set.of(), actualSubjectStudents.get(MUSIC));
    }

}
