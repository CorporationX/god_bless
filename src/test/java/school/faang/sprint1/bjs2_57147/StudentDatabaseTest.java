package school.faang.sprint1.bjs2_57147;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.sprint1.bjs2_57147.Student;
import school.faang.sprint1.bjs2_57147.StudentDatabase;
import school.faang.sprint1.bjs2_57147.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {
    private final Random randomValidGrade = new Random();
    private final Student ivan = new Student("Ivan");
    private final Student petya = new Student("Petya");
    private final Subject math = new Subject("Math");
    private final Subject english = new Subject("English");
    private final int gradeMin = 0;
    private final int gradeMax = 5;

    private StudentDatabase studentDatabase;
    private Map<Subject, Integer> subjects;
    private List<Student> students;
    private int grade;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();
        subjects = new HashMap<>();
        students = new ArrayList<>();
        grade = randomValidGrade.nextInt(gradeMin, gradeMax + 1);
    }

    @Test
    public void shouldPrintSubjectsWithStudentsWithoutExceptions() {
        studentDatabase.addStudentToSubject(math, ivan);
        studentDatabase.addStudentToSubject(english, ivan);

        assertDoesNotThrow(() -> studentDatabase.printSubjectsWithStudents());
    }

    @Test
    public void shouldPrintStudentInfoWithoutExceptions() {
        studentDatabase.addStudentToSubject(math, ivan);
        studentDatabase.addStudentToSubject(english, ivan);

        assertDoesNotThrow(() -> studentDatabase.printStudentInfo());
    }

    @Test
    @DisplayName("Добавление студенту два разных предмета")
    public void addStudent_addDifferentSubjects() {
        subjects.put(math, gradeMax);
        subjects.put(english, gradeMin);
        studentDatabase.addStudent(ivan, subjects);

        assertEquals(gradeMax, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertEquals(gradeMin, studentDatabase.getStudentSubjects().get(ivan).get(english));

        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
        assertTrue(studentDatabase.getSubjectStudents().get(english).contains(ivan));
    }


    @Test
    @DisplayName("Добавление студенту два раза предмет с разными оценками")
    public void addStudent_addSameSubject() {
        subjects.put(math, gradeMax);
        studentDatabase.addStudent(ivan, subjects);

        subjects.put(math, grade);
        studentDatabase.addStudent(ivan, subjects);

        assertEquals(grade, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Добавление студента с null картой предметов")
    public void addStudent_nullSubject() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabase.addStudent(ivan, null);
        });

        Assertions.assertFalse(studentDatabase.getStudentSubjects().containsKey(ivan));
        Assertions.assertTrue(studentDatabase.getSubjectStudents().isEmpty());
    }

    @Test
    @DisplayName("Добавление студенту только валидные предметы")
    public void addStudent_addValidSubjects() {
        subjects.put(math, grade);
        subjects.put(null, gradeMin);

        studentDatabase.addStudent(ivan, subjects);

        assertEquals(1, studentDatabase.getStudentSubjects().size());
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));

        assertEquals(1, studentDatabase.getSubjectStudents().size());
        assertTrue(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    @DisplayName("Не добавление студенту предметы с невалидными оценками")
    public void addStudent_invalidRatings() {
        subjects.put(math, gradeMax + 1);
        subjects.put(english, gradeMin - 1);

        studentDatabase.addStudent(ivan, subjects);
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertTrue(studentDatabase.getSubjectStudents().isEmpty());
    }

    @Test
    @DisplayName("Добавление студенту предмет только с валидной оценкой")
    public void addStudent_invalidRating() {
        subjects.put(math, gradeMax + 1);
        subjects.put(english, gradeMin);

        studentDatabase.addStudent(ivan, subjects);
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(english));
        assertFalse(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));

        assertFalse(studentDatabase.getSubjectStudents().containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().containsKey(english));
    }

    @Test
    @DisplayName("Добавление предмета с оценкой студенту")
    public void addSubjectToStudent_rightParam() {
        studentDatabase.addSubjectToStudent(math, ivan, grade);
        assertTrue(studentDatabase.getStudentSubjects().get(ivan).containsKey(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Добавление предмета с оценкой существующему студенту")
    public void addSubjectToStudent_ifContainsStudent() {
        studentDatabase.addSubjectToStudent(math, ivan, gradeMax);
        studentDatabase.addSubjectToStudent(math, ivan, grade);

        assertEquals(grade, studentDatabase.getStudentSubjects().get(ivan).get(math));
        assertTrue(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Ошибка добавления (null предмета) с оценкой студенту")
    public void addSubjectToStudent_nullSubject() {
        assertThrows(NullPointerException.class,
                () -> studentDatabase.addSubjectToStudent(null, ivan, gradeMax));
    }

    @Test
    @DisplayName("Ошибка добавления предмета с оценкой (null студенту)")
    public void addSubjectToStudent_nullStudent() {
        assertThrows(NullPointerException.class,
                () -> studentDatabase.addSubjectToStudent(math, null, gradeMax));
    }

    @Test
    @DisplayName("Ошибка добавления предмета с невалидной оценкой студенту")
    public void addSubjectToStudent_invalidRating() {
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(math, ivan, gradeMax + 1));
        assertThrows(IllegalArgumentException.class,
                () -> studentDatabase.addSubjectToStudent(math, ivan, gradeMin - 1));
    }

    @Test
    @DisplayName("Удаление существующего студента")
    public void removeStudent_hasStudent() {
        studentDatabase.addSubjectToStudent(math, ivan, grade);
        studentDatabase.removeStudent(ivan);

        assertNull(studentDatabase.getStudentSubjects().get(ivan));
        assertFalse(studentDatabase.getSubjectStudents().get(math).contains(ivan));
    }

    @Test
    @DisplayName("Удаление не существующего студента")
    public void removeStudent_hasNotStudent() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            studentDatabase.removeStudent(ivan);
        });

        Assertions.assertFalse(studentDatabase.getStudentSubjects().containsKey(ivan));
        studentDatabase.getSubjectStudents().values().forEach(students -> Assertions
                .assertFalse(students.contains(ivan)));
    }

    @Test
    @DisplayName("Добавление предмета и его студентов")
    public void addNewSubject_rightParam() {
        students.add(ivan);
        students.add(null);
        students.add(petya);
        students.add(null);
        students.add(petya);
        List<Student> filteredStudents = students.stream()
                .filter(Objects::nonNull)
                .distinct() // Убираем дубликаты
                .toList();

        studentDatabase.addNewSubject(math, filteredStudents);

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
        Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabase.addNewSubject(math, null);
        });
        Assertions.assertFalse(studentDatabase.getSubjectStudents().containsKey(math));
    }

    @Test
    @DisplayName("Ошибка добавление (null предмета) и его студентов")
    public void addNewSubject_nullSubject() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            studentDatabase.addNewSubject(null, students);
        });
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
        assertThrows(NullPointerException.class,
                () -> studentDatabase.addStudentToSubject(null, ivan));
    }

    @Test
    @DisplayName("Ошибка добавление предмету, null студента")
    public void addStudentToSubject_nullStudent() {
        assertThrows(NullPointerException.class,
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
        assertThrows(NullPointerException.class,
                () -> studentDatabase.removeStudentFromSubject(null, ivan));
    }

    @Test
    @DisplayName("Ошибка удаление у предмета null студента")
    public void removeStudentFromSubject_nullStudent() {
        assertThrows(NullPointerException.class,
                () -> studentDatabase.removeStudentFromSubject(math, null));
    }
}
