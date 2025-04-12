package school.faang.bjs2_68782;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static school.faang.bjs2_68782.data_set.TestData.ADDED_SUBJECTS_WITH_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.ALL_SUBJECTS_WITH_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.SOME_SUBJECTS_WITH_CHANGED_GRADES;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT1;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT2;
import static school.faang.bjs2_68782.data_set.TestData.STUDENT3;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AddSubjectForStudentTest {
    StudentDatabase studentDatabase = new StudentDatabase();

    @BeforeAll
    void setUp() {
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT1, ALL_SUBJECTS_WITH_GRADES);
        studentDatabase.addStudentWithSubjectsAndGrade(STUDENT2, SOME_SUBJECTS_WITH_CHANGED_GRADES);
    }

    @Test
    void testAddSubjectForStudentWhenStudentExistsThenAddNewSubject() {
        studentDatabase.addSubjectsForStudent(STUDENT2, ALL_SUBJECTS_WITH_GRADES);

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertEquals(ADDED_SUBJECTS_WITH_GRADES, actualStudentSubjects.get(STUDENT2));
    }

    @Test
    void testAddSubjectForStudentWhenStudentNotExistThenNotAddSubject() {
        studentDatabase.addSubjectsForStudent(STUDENT3, ALL_SUBJECTS_WITH_GRADES);

        var actualStudentSubjects = studentDatabase.getStudentSubjects();
        assertFalse(actualStudentSubjects.containsKey(STUDENT3));
    }
}
