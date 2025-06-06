package school.faang.cache2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Danil Pudovkin
 * @since 06.06.2025
 */
class StudentDatabaseTest {

    private final StudentDatabase db = new StudentDatabase();

    private final Student alex = new Student("Alex");
    private final Student max = new Student("Max");
    private final Student julia = new Student("Julia");
    private final Subject math = new Subject("Math");
    private final Subject physics = new Subject("Physics");
    private final Subject biology = new Subject("Biology");

    private final Map<Subject, Integer> alexSubjects = new HashMap<>(Map.of(
            math, 3,
            physics, 5
    ));
    private final Map<Subject, Integer> maxSubjects = new HashMap<>(Map.of(
            math, 5,
            biology, 4
    ));
    private final Map<Subject, Integer> juliaSubjects = new HashMap<>(Map.of(
            biology, 5
    ));

    @BeforeEach
    void setUp() {
        db.addNewStudentWithSubjects(alex, alexSubjects);
        db.addNewStudentWithSubjects(max, maxSubjects);
        db.addNewStudentWithSubjects(julia, juliaSubjects);
    }

    @AfterEach
    void tearDown() {
        db.deleteStudentWithSubjects(alex);
        db.deleteStudentWithSubjects(max);
        db.deleteStudentWithSubjects(julia);
    }

    @Nested
    @DisplayName("When add new student with subjects")
    class AddNewStudentWithSubjectsTest {

        @Test
        @DisplayName("Then get correct subjects")
        void testGetCorrectSubjects() {
            assertThat(db.getStudentSubjects().get(alex))
                    .containsAllEntriesOf(alexSubjects);
            assertThat(db.getStudentSubjects().get(max))
                    .containsAllEntriesOf(maxSubjects);
            assertThat(db.getStudentSubjects().get(julia))
                    .containsAllEntriesOf(juliaSubjects);
        }

        @Test
        @DisplayName("Then get correct students by subjects")
        void testGetCorrectStudentsBySubject() {
            assertThat(db.getSubjectStudents().get(math))
                    .containsAll(List.of(alex, max));
            assertThat(db.getSubjectStudents().get(biology))
                    .containsAll(List.of(max, julia));
            assertThat(db.getSubjectStudents().get(physics))
                    .contains(alex);
        }
    }

    @Nested
    @DisplayName("When add new subject to student")
    class AddNewSubjectToStudentTest {

        @BeforeEach
        void setUp() {
            db.addNewSubjectToStudent(julia, physics, 3);
            juliaSubjects.put(physics, 3);
        }

        @AfterEach
        void tearDown() {
            juliaSubjects.remove(physics);
        }

        @Test
        @DisplayName("Then get correct subjects")
        void testGetCorrectSubjects() {
            assertThat(db.getStudentSubjects().get(julia))
                    .containsAllEntriesOf(juliaSubjects);
        }

        @Test
        @DisplayName("Then get correct students by subjects")
        void testGetCorrectStudentsBySubject() {
            assertThat(db.getSubjectStudents().get(physics))
                    .containsAll(List.of(alex, julia));
        }
    }

    @Nested
    @DisplayName("When delete student with subjects")
    class DeleteStudentWithSubjectsTest {

        @BeforeEach
        void setUp() {
            db.deleteStudentWithSubjects(alex);
        }

        @Test
        @DisplayName("Then get correct subjects")
        void testGetCorrectSubjects() {
            assertThat(db.getStudentSubjects().get(alex))
                    .isNull();
        }

        @Test
        @DisplayName("Then get correct students by subjects")
        void testGetCorrectStudentsBySubject() {
            assertThat(db.getSubjectStudents().get(math))
                    .contains(max);
            assertThat(db.getSubjectStudents().get(physics))
                    .isEmpty();
        }
    }

    @Nested
    @DisplayName("When add new subject with students")
    class AddNewSubjectWithStudentsTest {

        @Test
        @DisplayName("And subject already exists, then get current students of this subject")
        void whenSubjectAlreadyExists_thenGetCorrectSubjectStudents() {
            db.addNewSubjectWithStudents(biology, List.of(alex, max));
            assertThat(db.getSubjectStudents().get(biology))
                    .containsAll(List.of(julia));
        }

        @Test
        @DisplayName("And subject doesn't exist, then get correct students of this subject")
        void whenSubjectDoesntExist_thenGetCorrectSubjectStudents() {
            var psychology = new Subject("Psychology");
            var students = List.of(alex, max, julia);
            db.addNewSubjectWithStudents(psychology, students);
            assertThat(db.getSubjectStudents().get(psychology))
                    .containsAll(students);
        }
    }

    @Nested
    @DisplayName("When add new student to subject")
    class AddNewStudentToSubjectTest {

        @Test
        @DisplayName("And subject doesn't exist, then don't add new student")
        void whenSubjectDoesntExist_thenDontAddNewStudent() {
            var chemistry = new Subject("Chemistry");
            db.addNewStudentToSubject(alex, chemistry);
            assertThat(db.getSubjectStudents().get(chemistry))
                    .isNull();
        }

        @Test
        @DisplayName("And subject exists, then add new student")
        void whenSubjectExists_thenAddNewStudent() {
            db.addNewStudentToSubject(alex, biology);
            assertThat(db.getSubjectStudents().get(biology))
                    .containsAll(List.of(julia, alex));
        }
    }

    @Nested
    @DisplayName("When delete student from subject")
    class DeleteStudentFromSubjectTest {

        @Test
        @DisplayName("And subject exists, then delete student")
        void whenSubjectExists_thenDeleteStudent() {
            db.deleteStudentFromSubject(julia, biology);
            assertThat(db.getSubjectStudents().get(biology))
                    .contains(max);
        }

        @Test
        @DisplayName("And subject doesn't exist, then do nothing")
        void whenSubjectDoesntExist_thenDoNothing() {
            var chemistry = new Subject("Chemistry");
            db.deleteStudentFromSubject(alex, chemistry);
            assertThat(db.getSubjectStudents().get(chemistry))
                    .isNull();
        }
    }
}