package school.faang.task_45390;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("StudentDatabaseTest")
class StudentDatabaseTest {

    @Test
    @DisplayName("addStudentWithGrades: should add student with grades correctly")
    void addStudentWithGrades_shouldAddStudentWithGradesCorrectly() {
        // Arrange
        Student student = new Student("John");
        Map<Subject, Integer> gradeBySubject = new HashMap<>();
        Subject math = new Subject("Math");
        Subject english = new Subject("English");
        gradeBySubject.put(math, 90);
        gradeBySubject.put(english, 85);

        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());

        // Act
        database.addStudentWithGrades(student, gradeBySubject);

        // Assert
        assertTrue(database.studentsBySubject.containsKey(math), "Math subject should contain the student");
        assertTrue(database.studentsBySubject.containsKey(english), "English subject should contain the student");
        assertTrue(database.gradesByStudent.containsKey(student), "Student should be in the gradesByStudent map");

        assertEquals(90, database.gradesByStudent.get(student).get(math), "Grade for Math should be 90");
        assertEquals(85, database.gradesByStudent.get(student).get(english), "Grade for English should be 85");
    }

    @Test
    @DisplayName("addSubjectForStudent: should add subject for student correctly")
    void addSubjectForStudent_shouldAddSubjectForStudentCorrectly() {
        // Arrange
        Student student = new Student("John");
        Subject subject = new Subject("History");
        int grade = 80;
        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());

        // Act
        database.addSubjectForStudent(student, subject, grade);

        // Assert
        assertTrue(database.studentsBySubject.containsKey(subject), "History subject should contain the student");
        assertTrue(database.gradesByStudent.containsKey(student), "Student should be in the gradesByStudent map");
        assertEquals(grade, database.gradesByStudent.get(student).get(subject), "Grade for History should be 80");
    }

    @Test
    @DisplayName("removeStudent: should remove student correctly")
    void removeStudent_shouldRemoveStudentCorrectly() {
        // Arrange
        Student student = new Student("John");
        Map<Subject, Integer> gradeBySubject = new HashMap<>();
        Subject math = new Subject("Math");
        gradeBySubject.put(math, 90);
        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());
        database.addStudentWithGrades(student, gradeBySubject);

        // Act
        database.removeStudent(student);

        // Assert
        assertFalse(database.gradesByStudent.containsKey(student), "Student should be removed from gradesByStudent");
        assertFalse(database.studentsBySubject.get(math).contains(student),
                "Student should be removed from Math subject");
    }

    @Test
    @DisplayName("removeStudentFromSubject: should remove student from subject correctly")
    void removeStudentFromSubject_shouldRemoveStudentFromSubjectCorrectly() {
        // Arrange
        Student student = new Student("John");
        Subject math = new Subject("Math");
        Map<Subject, Integer> gradeBySubject = new HashMap<>();
        gradeBySubject.put(math, 90);
        StudentDatabase database = new StudentDatabase(new HashMap<>(), new HashMap<>());
        database.addStudentWithGrades(student, gradeBySubject);

        // Act
        database.removeStudentFromSubject(student, math);

        // Assert
        assertNull(database.gradesByStudent.get(student).get(math), "Student should be removed from Math subject");
        assertFalse(database.studentsBySubject.get(math).contains(student),
                "Student should be removed from Math subject list");
    }
}