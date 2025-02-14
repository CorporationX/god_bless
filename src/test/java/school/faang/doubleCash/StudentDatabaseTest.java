package school.faang.doubleCash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private StudentDatabase database;
    private Student student1;
    private Student student2;
    private Subject math;
    private Subject physics;

    @BeforeEach
    void setUp() {
        database = new StudentDatabase();
        student1 = new Student("Иван Иванов");
        student2 = new Student("Петр Петров");
        math = new Subject("Математика");
        physics = new Subject("Физика");
    }

    @Test
    @DisplayName("Добавление нового студента с оценками")
    void testAddNewStudentWithGrades() {
        Map<Subject, Integer> grades = new HashMap<>();
        grades.put(math, 5);
        grades.put(physics, 4);

        database.addNewStudentWithGrades(student1, grades);
        assertThrows(IllegalArgumentException.class, () -> database.addNewStudentWithGrades(student1, grades));
    }

    @Test
    @DisplayName("Добавление предмета студенту")
    void testAddSubjectForStudent() {
        database.addNewStudentWithGrades(student1, new HashMap<>());
        database.addSubjectForStudent(student1, math, 5);
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectForStudent(student1, math, 4));
    }

    @Test
    @DisplayName("Удаление студента")
    void testRemoveStudent() {
        database.addNewStudentWithGrades(student1, new HashMap<>());
        database.removeStudent(student1);
        assertThrows(IllegalArgumentException.class, () -> database.removeStudent(student1));
    }

    @Test
    @DisplayName("Добавление предмета со студентами")
    void testAddSubjectWithStudents() {
        List<Student> students = new ArrayList<>(List.of(student1, student2));
        database.addSubjectWithStudents(math, students);
        assertThrows(IllegalArgumentException.class, () -> database.addSubjectWithStudents(math, students));
    }

    @Test
    @DisplayName("Добавление студента в предмет")
    void testAddStudentToSubject() {
        database.addSubjectWithStudents(math, new ArrayList<>());
        database.addStudentToSubject(student1, math);
        assertThrows(IllegalArgumentException.class, () -> database.addStudentToSubject(student1, physics));
    }

    @Test
    @DisplayName("Удаление студента из предмета")
    void testRemoveStudentFromSubject() {
        database.addNewStudentWithGrades(student1, Map.of(math, 5));
        database.removeStudentFromSubject(student1, math);
        assertThrows(IllegalArgumentException.class, () -> database.removeStudentFromSubject(student1, math));
    }
}