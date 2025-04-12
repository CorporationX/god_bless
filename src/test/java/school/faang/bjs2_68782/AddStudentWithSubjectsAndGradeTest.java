package school.faang.bjs2_68782;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static school.faang.bjs2_68782.data_set.TestData.ALL_SUBJECTS_WITH_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.SOME_SUBJECTS_WITH_CHANGED_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT1;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT2;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT3;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT4;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddStudentWithSubjectsAndGradeTest {
    private final StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT1, ALL_SUBJECTS_WITH_GRADES);
    }

    @Test
    void testAddStudentWithSubjectsAndGradeWhenNewStudentThenAddedToMap() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT2, ALL_SUBJECTS_WITH_GRADES);

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertTrue(actualStudentSubjects.containsKey(STUDENT2));
        assertEquals(ALL_SUBJECTS_WITH_GRADES, actualStudentSubjects.get(STUDENT2));
    }

    @Test
    void testAddStudentWithSubjectsAndGradeWhenExistingStudentThenDoNotAdd() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT1, SOME_SUBJECTS_WITH_CHANGED_GRADES);

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertTrue(actualStudentSubjects.containsKey(STUDENT1));
        assertEquals(ALL_SUBJECTS_WITH_GRADES, actualStudentSubjects.get(STUDENT1));
    }

    @Test
    void testAddStudentWithSubjectsAndGradeWhenEmptySubjectsThenAddStudentWOSubjects() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT3, Map.of());

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertTrue(actualStudentSubjects.containsKey(STUDENT3));
        assertEquals(Map.of(), actualStudentSubjects.get(STUDENT3));
    }

    @Test
    void testAddStudentWithSubjectsAndGradeWhenNullSubjectsThenAddOnlyStudent() {
        Map<Subject, Integer> subjAndGrade = new HashMap<>();
        subjAndGrade.put(null, null);
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT4, subjAndGrade);

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertTrue(actualStudentSubjects.containsKey(STUDENT4));
        assertEquals(subjAndGrade, actualStudentSubjects.get(STUDENT4));
    }
}
