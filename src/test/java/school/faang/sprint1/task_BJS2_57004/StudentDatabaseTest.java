package school.faang.sprint1.task_BJS2_57004;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class StudentDatabaseTest {
    private final Random randomValidRating = new Random();
    private final String ivanName = "Ivan";
    private final Student ivan = new Student(ivanName);
    private final Student petya = new Student("Petya");
    private final Subject math = new Subject("Math");
    private final Subject english = new Subject("English");
    private final int minRating = 0;
    private final int maxRating = 5;

    private StudentDatabase studentDatabase;
    private Map<Subject, Integer> subjects;
    private List<Student> students;
    private int rating;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();
        subjects = new HashMap<>();
        students = new ArrayList<>();
        rating = randomValidRating.nextInt(minRating, maxRating + 1);
    }

    @Test
    @DisplayName("Добавление студенту два разных предмета")
    public void addStudent_addDifferentSubjects() {
        subjects.put(math, maxRating);
        subjects.put(english, minRating);
        studentDatabase.addStudent(ivanName, subjects);

        assertEquals(maxRating, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertEquals(minRating, studentDatabase.getStudentSubjects().get(ivan).get(english));

        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
        assertTrue(studentDatabase.getSubjectStudents().get(english).contains(ivan));
    }


    @Test
    @DisplayName("Добавление студенту два раза предмет с разными оценками")
    public void addStudent_addSameSubject() {
        subjects.put(math, maxRating);
        studentDatabase.addStudent(ivanName, subjects);

        subjects.put(math, rating);
        studentDatabase.addStudent(ivanName, subjects);

        assertEquals(rating, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Добавление студента с null картой предметов")
    public void addStudent_nullSubject() {
        studentDatabase.addStudent(ivanName, null);

        assertTrue(studentDatabase.getStudentSubjects().get(ivan).isEmpty());
        assertTrue(studentDatabase.getSubjectStudents().isEmpty());
    }

    @Test
    @DisplayName("Добавление студенту только валидные предметы")
    public void addStudent_addValidSubjects() {
        subjects.put(math, rating);
        subjects.put(null, minRating);

        studentDatabase.addStudent(ivanName, subjects);

        assertEquals(1, studentDatabase.getStudentSubjects().size());
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));

        assertEquals(1, studentDatabase.getSubjectStudents().size());
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    @DisplayName("Не добавление студенту предметы с невалидными оценками")
    public void addStudent_invalidRatings() {
        subjects.put(math, maxRating + 1);
        subjects.put(english, minRating - 1);

        studentDatabase.addStudent(ivanName, subjects);
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertTrue(studentDatabase.getSubjectStudents().isEmpty());
    }

    @Test
    @DisplayName("Добавление студенту предмет только с валидной оценкой")
    public void addStudent_invalidRating() {
        subjects.put(math, maxRating + 1);
        subjects.put(english, minRating);

        studentDatabase.addStudent(ivanName, subjects);
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));

        assertFalse(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(english));
    }

    @Test
    @DisplayName("Добавление предмета с оценкой студенту")
    public void addSubjectToStudent_rightParam() {
        studentDatabase.addSubjectToStudent(math, ivan, rating);
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Добавление предмета с оценкой существующему студенту")
    public void addSubjectToStudent_ifContainsStudent() {
        studentDatabase.addSubjectToStudent(math, ivan, maxRating);
        studentDatabase.addSubjectToStudent(math, ivan, rating);

        assertEquals(rating, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Ошибка добавления (null предмета) с оценкой студенту")
    public void addSubjectToStudent_nullSubject() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(null, ivan, maxRating));
    }

    @Test
    @DisplayName("Ошибка добавления предмета с оценкой (null студенту)")
    public void addSubjectToStudent_nullStudent() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(math, null, maxRating));
    }

    @Test
    @DisplayName("Ошибка добавления предмета с невалидной оценкой студенту")
    public void addSubjectToStudent_invalidRating() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(math, ivan, maxRating + 1));
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(math, ivan, minRating - 1));
    }

    @Test
    @DisplayName("Удаление существующего студента")
    public void removeStudent_hasStudent() {
        studentDatabase.addSubjectToStudent(math, ivan, rating);
        studentDatabase.removeStudent(ivan);

        assertNull(studentDatabase.getStudentSubjects().get(ivan));
        assertFalse(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Удаление не существующего студента")
    public void removeStudent_hasNotStudent() {
        studentDatabase.removeStudent(ivan);

        assertNull(studentDatabase.getStudentSubjects().get(ivan));
        studentDatabase.getSubjectStudents().forEach((subject, students) -> assertFalse(students.contains(ivan)));
    }

    @Test
    @DisplayName("Добавление предмета и его студентов")
    public void addNewSubject_rightParam() {
        students.add(ivan);
        students.add(null);
        students.add(petya);
        students.add(null);
        students.add(petya);
        studentDatabase.addNewSubject(math, students);

        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));
        assertTrue(studentDatabase.getStudentSubjects().get(petya).containsKey(math));

        assertEquals(2, studentDatabase.getSubjectStudents().get(math).size());
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(petya));
    }

    @Test
    @DisplayName("Ошибка добавление предмета при пустых студентов)")
    public void addNewSubject_emptyStudents() {
        assertDoesNotThrow(() -> studentDatabase.addNewSubject(math, students));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    @DisplayName("Ошибка добавление предмета при null студентов")
    public void addNewSubject_nullStudents() {
        assertDoesNotThrow(() -> studentDatabase.addNewSubject(math, null));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    @DisplayName("Ошибка добавление (null предмета) и его студентов")
    public void addNewSubject_nullSubject() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addNewSubject(null, students));
    }

    @Test
    @DisplayName("Добавление предмету студента")
    public void addStudentToSubject_rightParam() {
        studentDatabase.addStudentToSubject(english, ivan);

        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertTrue(studentDatabase.getSubjectStudents().get(english).contains(ivan));
    }

    @Test
    @DisplayName("Ошибка добавление null предмету студента")
    public void addStudentToSubject_nullSubject() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addStudentToSubject(null, ivan));
    }

    @Test
    @DisplayName("Ошибка добавление предмету, null студента")
    public void addStudentToSubject_nullStudent() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addStudentToSubject(english, null));
    }

    @Test
    @DisplayName("Удаление у предмета студента")
    public void removeStudentFromSubject_rightParam() {
        studentDatabase.addStudentToSubject(math, ivan);
        studentDatabase.addStudentToSubject(english, ivan);
        studentDatabase.removeStudentFromSubject(english, ivan);

        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));

        assertFalse(studentDatabase.getSubjectStudents().get(english).contains(ivan));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Удаление у не существующего предмета и студента")
    public void removeStudentFromSubject_hasNotSubject() {
        assertDoesNotThrow(() -> studentDatabase.removeStudentFromSubject(english, ivan));
    }

    @Test
    @DisplayName("Ошибка удаление у null предмета студента")
    public void removeStudentFromSubject_nullSubject() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.removeStudentFromSubject(null, ivan));
    }

    @Test
    @DisplayName("Ошибка удаление у предмета null студента")
    public void removeStudentFromSubject_nullStudent() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.removeStudentFromSubject(math, null));
    }
}