package school.faang.doublecash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentDatabaseTest {

    private StudentDatabase studentDatabase;
    private Student tolik;
    private Student timur;
    private Subject math;
    private Subject english;

    @BeforeEach
    public void setUp() {
        studentDatabase = new StudentDatabase();
        tolik = new Student("Tolik");
        timur = new Student("Timur");
        math = new Subject("Math");
        english = new Subject("English");
    }

    @Test
    @DisplayName("Добавление нового предмета для существующего студента с оценкой")
    public void testAddSubjectToStudent() {
        studentDatabase.addSubjectToStudent(tolik, math, 3);

        Map<Subject, Integer> studentSubjectsMarks = studentDatabase.getStudentSubjects().get(tolik);
        assertThat(studentSubjectsMarks).isNotNull();
        assertThat(studentSubjectsMarks).containsEntry(math, 3);

        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertThat(subjectStudents).isNotNull();
        assertThat(subjectStudents.get(math)).contains(tolik);
    }

    @Test
    @DisplayName("Добавление нового студента и его предметов с оценками")
    public void testAddStudentWithGrades() {
        Map<Subject, Integer> subjectMark = new HashMap<>();
        subjectMark.put(math, 3);
        subjectMark.put(english, 5);
        studentDatabase.addStudentWithGrades(tolik, subjectMark);

        Map<Student, Map<Subject, Integer>> studentSubject = studentDatabase.getStudentSubjects();
        assertThat(studentSubject).isNotNull();
        assertThat(studentSubject).containsEntry(tolik, subjectMark);

        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertThat(subjectStudents).isNotNull();
        assertThat(subjectStudents.get(math)).contains(tolik);
        assertThat(subjectStudents.get(english)).contains(tolik);
    }

    @Test
    @DisplayName("Удаление студента и его предметов")
    public void testRemoveStudent() {
        Map<Subject, Integer> subjectMark = new HashMap<>();
        subjectMark.put(math, 3);
        subjectMark.put(english, 5);
        studentDatabase.addStudentWithGrades(tolik, subjectMark);

        studentDatabase.removeStudent(tolik);

        Map<Student, Map<Subject, Integer>> studentSubject = studentDatabase.getStudentSubjects();
        assertThat(studentSubject).isEmpty();

        Map<Subject, List<Student>> subjectStudents = studentDatabase.getSubjectStudents();
        assertThat(subjectStudents).isEmpty();
    }

    @Test
    @DisplayName("Вывод списка всех студентов и их оценок по предметам")
    public void testPrintAllStudentsWithMarks() {
        studentDatabase.addSubjectToStudent(tolik, math, 3);
        studentDatabase.addSubjectToStudent(tolik, english, 5);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        studentDatabase.printAllStudentsWithMarks();

        System.setOut(System.out);

        String result = output.toString();
        assertTrue(result.contains("Информация о студенте: Tolik"));
        assertTrue(result.contains("По предмету - Math оценка - 3"));
        assertTrue(result.contains("По предмету - English оценка - 5"));
    }

    @Test
    @DisplayName("Добавление нового предмета и списка студентов, изучающих его")
    public void testAddNewSubjectWithStudents() {
        List<Student> studentsBySubject = List.of(timur, tolik);

        studentDatabase.addNewSubjectWithStudents(math, studentsBySubject);

        assertThat(studentDatabase.getSubjectStudents()).isNotNull();
        assertThat(studentDatabase.getSubjectStudents()).containsEntry(math, studentsBySubject);
    }

    @Test
    @DisplayName("Добавление студента к существующему предмету")
    public void testAddStudentToSubject() {
        studentDatabase.addStudentToSubject(tolik, math);

        assertThat(studentDatabase.getSubjectStudents()).isNotNull();
        assertThat(studentDatabase.getSubjectStudents().get(math)).contains(tolik);
    }

    @Test
    @DisplayName("Удаление студента из предмета")
    public void testRemoveStudentFromSubject() {
        List<Student> studentsBySubject = List.of(timur, tolik);
        studentDatabase.addNewSubjectWithStudents(math, studentsBySubject);

        studentDatabase.removeStudentFromSubject(timur, math);

        assertFalse(studentDatabase.getSubjectStudents().get(math).contains(timur));
    }

    @Test
    @DisplayName("Вывод списка всех предметов и студентов, изучающих их")
    public void testPrintAllSubjectStudents() {
        studentDatabase.addSubjectToStudent(tolik, math, 3);
        studentDatabase.addSubjectToStudent(timur, math, 5);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        studentDatabase.printAllSubjectStudents();

        System.setOut(System.out);

        String result = output.toString();
        assertTrue(result.contains("Предмет Math изучают студенты:"));
        assertTrue(result.contains(" - Tolik"));
        assertTrue(result.contains(" - Timur"));
    }
}
