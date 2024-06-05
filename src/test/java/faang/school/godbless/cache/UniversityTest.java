package faang.school.godbless.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    private final University university = new University();

    @BeforeEach
    public void setUp() {
        university.setStudentGrades(new HashMap<>());
        university.setStudentsBySubjects(new HashMap<>());
    }

    @Test
    @DisplayName("Adding a student with grades should increase map size and have a value with subject and grades")
    void testAddStudentWithGradesSavesNewData() {
        Student student = new Student(1L, "Trevor");
        Map<Subject, Integer> defaultGrades = prepareDefaultGrades();

        university.addStudentWithGrades(student, defaultGrades);

        assertEquals(defaultGrades, university.getStudentGrades().get(student));
    }

    @Test
    @DisplayName("Adding a null student should throw exception")
    void testAddNullStudent() {
        Map<Subject, Integer> defaultGrades = prepareDefaultGrades();

        assertThrows(IllegalArgumentException.class, () -> university.addStudentWithGrades(null, defaultGrades));
    }

    @Test
    @DisplayName("Adding a student with null grades should throw exception")
    void testAddStudentWithNullGrades() {
        Student student = new Student(1L, "Trevor");

        assertThrows(IllegalArgumentException.class, () -> university.addStudentWithGrades(student, null));
    }

    @Test
    @DisplayName("Adding new graded subject to student should increase subjects size")
    void testAddSubjectGradeSavesNewData() {
        Student student = new Student(1L, "Trevor");
        Map<Student, Map<Subject, Integer>> studentGrades = prepareStudentWithDefaultGrades(student);
        university.setStudentGrades(studentGrades);

        university.addSubjectGrade(student, new Subject(17L, "Literature"), 3);

        assertEquals(5, university.getStudentGrades().get(student).size());
    }

    @Test
    @DisplayName("Adding a null subject grade should throw exception")
    void testAddNullSubjectGrade() {
        Student student = new Student(1L, "Trevor");

        assertThrows(IllegalArgumentException.class, () -> university.addSubjectGrade(student, null, 3));
    }

    @Test
    @DisplayName("Adding a subject grade for null student should throw exception")
    void testAddSubjectGradeForNullStudent() {
        Subject literature = new Subject(15L, "Literature");

        assertThrows(IllegalArgumentException.class, () -> university.addSubjectGrade(null, literature, 3));
    }

    @Test
    @DisplayName("Adding a subject grade for student that is not present")
    void testAddSubjectGradeForNonExistentStudent() {
        Student student = new Student(2L, "Marco");

        assertThrows(IllegalArgumentException.class, () -> university.addSubjectGrade(student, null, 3));
    }

    @Test
    @DisplayName("Removing a student should remove their subject grades")
    void testRemoveStudentRemovesSubjectGrades() {
        Student student = new Student(1L, "Trevor");
        Map<Student, Map<Subject, Integer>> studentGrades = prepareStudentWithDefaultGrades(student);
        university.setStudentGrades(studentGrades);

        university.removeStudent(student);

        assertEquals(0, university.getStudentGrades().size());
    }

    @Test
    @DisplayName("Removing a null student throws exception")
    void testRemoveNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> university.removeStudent(null));
    }

    @Test
    @DisplayName("Adding a subject with students should increase map size and have list of students as value")
    void testAddSubjectWithStudents() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));

        university.addSubjectWithStudents(art, artStudents);

        assertEquals(1, university.getStudentsBySubjects().size());
    }

    @Test
    @DisplayName("Adding a subject with null students throws an exception")
    void testAddSubjectWithNullStudents() {
        Subject art = new Subject(1L, "Art");

        assertThrows(IllegalArgumentException.class, () -> university.addSubjectWithStudents(art, null));
    }

    @Test
    @DisplayName("Adding a subject with null students throws an exception")
    void testAddNullSubject() {
        assertThrows(IllegalArgumentException.class, () -> university.addSubjectWithStudents(null, Collections.emptyList()));
    }

    @Test
    @DisplayName("Adding a student to the subject increases class size")
    void testAddStudentToCurrentSubject() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));
        university.setStudentsBySubjects(prepareSubjectsWithStudents(art, artStudents));
        Student newStudent = new Student(5L, "Naomi");

        university.addStudentToCurrentSubject(art, newStudent);

        assertEquals(3, university.getStudentsBySubjects().get(art).size());
    }

    @Test
    @DisplayName("Adding a subject with null students throws an exception")
    void testAddNullStudentsToCurrentSubject() {
        Subject art = new Subject(1L, "Art");
        assertThrows(IllegalArgumentException.class, () -> university.addStudentToCurrentSubject(art, null));
    }

    @Test
    @DisplayName("Adding a null subject throws an exception")
    void testAddStudentToNullSubject() {
        Student newStudent = new Student(5L, "Naomi");
        assertThrows(IllegalArgumentException.class, () -> university.addStudentToCurrentSubject(null, newStudent));
    }

    @Test
    @DisplayName("Removing a student from subject should decrease student list size")
    void testRemoveStudentFromSubject() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));
        university.setStudentsBySubjects(prepareSubjectsWithStudents(art, artStudents));

        university.removeStudentFromSubject(art, artStudents.get(0));

        assertEquals(1, university.getStudentsBySubjects().get(art).size());
    }

    @Test
    @DisplayName("Removing a student from null subject throws an exception")
    void testRemoveStudentFromNullSubject() {
        Student student = new Student(5L, "Naomi");
        assertThrows(IllegalArgumentException.class, () -> university.removeStudentFromSubject(null, student));
    }

    @Test
    @DisplayName("Removing a null student from subject throws an exception")
    void testRemoveNullStudentFromSubject() {
        Subject art = new Subject(1L, "Art");
        assertThrows(IllegalArgumentException.class, () -> university.addStudentToCurrentSubject(art, null));
    }

    private Map<Subject, Integer> prepareDefaultGrades() {
        Map<Subject, Integer> subjectIntegerMap = Map.of(
                new Subject(1L, "Math"), 5,
                new Subject(2L, "Physics"), 4,
                new Subject(3L, "English"), 5,
                new Subject(4L, "PE"), 4
        );
        return new HashMap<>(subjectIntegerMap);
    }

    private Map<Student, Map<Subject, Integer>> prepareStudentWithDefaultGrades(Student student) {
        Map<Student, Map<Subject, Integer>> studentWithDefaultGrades = Map.of(student, prepareDefaultGrades());
        return new HashMap<>(studentWithDefaultGrades);
    }

    private Map<Subject, List<Student>> prepareSubjectsWithStudents(Subject subject, List<Student> students) {
        return new HashMap<>(Map.of(subject, new ArrayList<>(students)));
    }
}