package school.faang.doublecash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase studentDatabase;

    @BeforeEach
    void setUp() {
        studentDatabase = new StudentDatabase();
    }

    @Test
    @DisplayName("Добавление студента с оценками в базу студентов")
    void testAddStudentWithGrades() {
        String nameStudent = "Игорь";
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(new Subject("Химия"), 4);
        grades.put(new Subject("Математика"), 5);

        studentDatabase.addStudentWithGrades(nameStudent, grades);

        assertEquals(1, studentDatabase.getStudentSubjects().size());
        assertTrue(studentDatabase.getStudentSubjects().containsKey(new Student(nameStudent)));

        assertEquals(grades, studentDatabase.getStudentSubjects().get(new Student(nameStudent)));
    }

    @Test
    @DisplayName("Добавление студента в базу предметов")
    void testAddStudentWithGradesToSubjectStudents() {
        String nameStudent = "Игорь";
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(new Subject("Химия"), 4);
        grades.put(new Subject("Математика"), 5);

        studentDatabase.addStudentWithGrades(nameStudent, grades);

        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("Химия")));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(new Subject("Математика")));

        assertEquals(1, studentDatabase.getSubjectStudents().get(new Subject("Химия")).size());
        assertEquals(1, studentDatabase.getSubjectStudents().get(new Subject("Математика")).size());

        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("Химия"))
                .contains(new Student(nameStudent)));
        assertTrue(studentDatabase.getSubjectStudents().get(new Subject("Математика"))
                .contains(new Student(nameStudent)));
    }

    @Test
    @DisplayName("Некорректное значение списка оценок")
    void testAddStudentWithEmptyGrades() {
        String nameStudent = "Игорь";
        Map<Subject, Integer> grades = new HashMap<>();

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addStudentWithGrades(nameStudent, grades));
        assertEquals("Предметы с оценками не могут быть null", e.getMessage());
    }

    @Test
    @DisplayName("Некорректное имя студента")
    void testAddInvalidNameStudentWithGrades() {
        String nameStudent = "";
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(new Subject("Химия"), 4);
        grades.put(new Subject("Математика"), 5);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addStudentWithGrades(nameStudent, grades));
        assertEquals("Имя не может быть пустым", e.getMessage());
    }
}