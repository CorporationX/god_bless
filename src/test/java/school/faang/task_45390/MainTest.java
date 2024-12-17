package school.faang.task_45390;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("MainTest")
class MainTest {

    private Map<Student, Map<Subject, Integer>> gradesByStudent;
    private Map<Subject, List<Student>> studentsBySubject;
    private Subject math;
    private Subject physics;
    private Student john;
    private Student mark;
    private Student bob;

    @BeforeEach
    void setUp() {
        gradesByStudent = new HashMap<>();
        studentsBySubject = new HashMap<>();
        math = new Subject("Math");
        physics = new Subject("Physics");
        john = new Student("John");
        mark = new Student("Mark");
        bob = new Student("Bob");
    }

    @Test
    @DisplayName("addGrade: should add grade to student for the subject")
    void addGrade_shouldAddGradeToStudentForTheSubject() {
        // Act
        Main.addGrade(gradesByStudent, mark, math, 90);
        Main.addGrade(gradesByStudent, bob, physics, 85);

        // Assert
        assertEquals(90, gradesByStudent.get(mark).get(math), "Grade for Mark in Math should be 90");
        assertEquals(85, gradesByStudent.get(bob).get(physics), "Grade for Bob in Physics should be 85");
    }

    @Test
    @DisplayName("addStudentToSubject: should add students to subject correctly")
    void addStudentToSubject_shouldAddStudentsToSubjectCorrectly() {
        // Act
        Main.addStudentToSubject(studentsBySubject, math, mark, bob);
        Main.addStudentToSubject(studentsBySubject, physics, john);

        // Assert
        assertTrue(studentsBySubject.get(math).contains(mark), "Mark should be added to Math");
        assertTrue(studentsBySubject.get(math).contains(bob), "Bob should be added to Math");
        assertTrue(studentsBySubject.get(physics).contains(john), "John should be added to Physics");
    }

    @Test
    @DisplayName("validateStudentsBySubjectConsistency: "
            + "should throw exception if a student is assigned to a subject without grade")
    void validateStudentsBySubjectConsistency_shouldThrowExceptionIfNoGradeForAssignedSubject() {
        // Arrange
        Main.addStudentToSubject(studentsBySubject, math, mark, bob);
        Main.addGrade(gradesByStudent, mark, math, 90);

        // Act & Assert
        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                Main.validateStudentsBySubjectConsistency(studentsBySubject, gradesByStudent)
        );
        assertEquals("Student Bob is assigned to subject Math but has no grade for it.", exception.getMessage());
    }

    @Test
    @DisplayName("validateStudentsBySubjectConsistency: "
            + "should pass validation if all students have grades for assigned subjects")
    void validateStudentsBySubjectConsistency_shouldPassValidationIfAllStudentsHaveGradesForAssignedSubjects() {
        // Arrange
        Main.addStudentToSubject(studentsBySubject, math, mark, bob);
        Main.addStudentToSubject(studentsBySubject, physics, john);
        Main.addGrade(gradesByStudent, mark, math, 90);
        Main.addGrade(gradesByStudent, bob, math, 80);
        Main.addGrade(gradesByStudent, john, physics, 85);

        // Act & Assert
        assertDoesNotThrow(() ->
                Main.validateStudentsBySubjectConsistency(studentsBySubject, gradesByStudent)
        );
    }
}