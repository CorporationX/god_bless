package faang.school.godbless.cache;

import faang.school.godbless.intro.cache.Student;
import faang.school.godbless.intro.cache.Subject;
import faang.school.godbless.intro.cache.University;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    private final University university = new University();

    @BeforeEach
    public void setUp() {
        university.setStudentGrades(new HashMap<>());
        university.setStudentsBySubjects(new HashMap<>());
    }

    @Test
    @DisplayName("Adding a student with grades should update both maps")
    void testAddStudentWithGradesSavesNewDataAndUpdatesTwoMaps() {
        Student student = new Student(1L, "Trevor");
        Map<Subject, Integer> defaultGrades = prepareDefaultGrades();

        university.addStudentWithGrades(student, defaultGrades);

        assertEquals(defaultGrades, university.getStudentGrades().get(student));
        university.getStudentsBySubjects().forEach((subject, grades) -> assertTrue(grades.contains(student)));
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
    @DisplayName("Adding new graded subject to student should update both maps")
    void testAddSubjectGradeSavesNewData() {
        Student student = new Student(1L, "Trevor");
        Map<Student, Map<Subject, Integer>> studentGrades = prepareStudentWithDefaultGrades(student);
        university.setStudentGrades(studentGrades);
        Subject literature = new Subject(17L, "Literature");

        university.addSubjectGrade(student, literature, 3);

        assertEquals(5, university.getStudentGrades().get(student).size());
        assertTrue(university.getStudentsBySubjects().get(literature).contains(student));
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
    @DisplayName("Adding a subject grade for student that is not present should throw exception")
    void testAddSubjectGradeForNonExistentStudent() {
        Student student = new Student(2L, "Marco");

        assertThrows(IllegalArgumentException.class, () -> university.addSubjectGrade(student, null, 3));
    }

    @Test
    @DisplayName("Removing a student should remove their subject grades and update second map")
    void testRemoveStudentRemovesSubjectGrades() {
        Student student = new Student(1L, "Trevor");
        Map<Student, Map<Subject, Integer>> studentGrades = prepareStudentWithDefaultGrades(student);
        university.setStudentGrades(studentGrades);
        Map<Subject, List<Student>> studentsBySubjects = prepareSubjectsWithOneStudent(studentGrades.get(student).keySet(), student);
        university.setStudentsBySubjects(studentsBySubjects);

        university.removeStudent(student);

        assertEquals(0, university.getStudentGrades().size());
        university.getStudentsBySubjects().forEach((subject, students) -> assertFalse(students.contains(student)));
    }

    @Test
    @DisplayName("Removing a null student throws exception")
    void testRemoveNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> university.removeStudent(null));
    }

    @Test
    @DisplayName("Adding a subject with students should update both maps")
    void testAddSubjectWithStudents() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));

        university.addSubjectWithStudents(art, artStudents);

        assertEquals(1, university.getStudentsBySubjects().size());
        university.getStudentGrades().forEach((student, subjectGrades) -> assertTrue(subjectGrades.containsKey(art)));
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
    @DisplayName("Adding a student to the subject updates both maps")
    void testAddStudentToCurrentSubject() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));
        university.setStudentsBySubjects(prepareSubjectsWithStudents(art, artStudents));
        Student newStudent = new Student(5L, "Naomi");

        university.addStudentToCurrentSubject(art, newStudent);

        assertEquals(3, university.getStudentsBySubjects().get(art).size());
        assertTrue(university.getStudentGrades().get(newStudent).containsKey(art));
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
    @DisplayName("Removing a student from subject should update both maps")
    void testRemoveStudentFromSubject() {
        Subject art = new Subject(1L, "Art");
        List<Student> artStudents = List.of(new Student(1L, "Trevor"), new Student(2L, "Marco"));
        university.setStudentsBySubjects(prepareSubjectsWithStudents(art, artStudents));
        Student studentToBeDeleted = artStudents.get(0);
        Map<Student, Map<Subject, Integer>> studentGrades = new HashMap<>();
        studentGrades.put(studentToBeDeleted, new HashMap<>(Map.of(art, 5)));
        university.setStudentGrades(studentGrades);

        university.removeStudentFromSubject(art, studentToBeDeleted);

        assertEquals(1, university.getStudentsBySubjects().get(art).size());
        assertTrue(university.getStudentGrades().isEmpty());
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

    private Map<Subject, List<Student>> prepareSubjectsWithOneStudent(Set<Subject> subjects, Student student) {
        HashMap<Subject, List<Student>> studentsBySubjects = new HashMap<>();
        subjects.forEach(subject -> studentsBySubjects.computeIfAbsent(subject, v -> new ArrayList<>()).add(student));
        return studentsBySubjects;
    }
}