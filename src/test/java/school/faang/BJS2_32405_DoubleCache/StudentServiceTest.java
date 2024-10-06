package school.faang.BJS2_32405_DoubleCache;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceTest {
    StudentService service;
    Student John;
    Student Alice;
    Subject math;
    Subject physics;

    @BeforeEach
    void setUp() {
        service = new StudentService();
        John = new Student(1, "John");
        Alice = new Student(2, "Alice");
        math = new Subject(1,"Math");
        physics = new Subject(2, "Physics");
    }

    @Test
    @DisplayName("Adding multiple subjects' scores for a student")
    void testAddStudentSubjectsScores() {
        Map<Subject, Integer> johnScores = new HashMap<>();
        johnScores.put(math, 90);
        johnScores.put(physics, 85);
        service.addStudentSubjectsScores(John, johnScores);

        assertEquals(1, service.getStudentsCount());
        assertEquals(2, service.getSubjectsCount());

        Map<Subject, Integer> aliceScores = new HashMap<>();
        aliceScores.put(math, 80);
        aliceScores.put(physics, 95);
        service.addStudentSubjectsScores(Alice, aliceScores);

        assertEquals(2, service.getStudentsCount());
        assertEquals(2, service.getSubjectsCount());
    }

    @Test
    @DisplayName("Adding single subject score for a student")
    void testAddStudentSubjectScore() {
        service.addStudentSubjectScore(John, math, 65);

        assertEquals(1, service.getStudentsCount());
        assertEquals(1, service.getSubjectsCount());

        service.addStudentSubjectScore(Alice, math, 78);
        service.addStudentSubjectScore(Alice, physics, 81);

        assertEquals(2, service.getStudentsCount());
        assertEquals(2, service.getSubjectsCount());
    }

    @Test
    @DisplayName("Removing the student from DB")
    void testRemoveStudent() {
        service.addStudentSubjectScore(John, math, 78);
        service.addStudentSubjectScore(Alice, physics, 81);
        service.addStudentSubjectScore(Alice, math, 78);

        service.removeStudent(John);

        assertEquals(1, service.getStudentsCount());
        assertEquals(2, service.getSubjectsCount());
    }
}