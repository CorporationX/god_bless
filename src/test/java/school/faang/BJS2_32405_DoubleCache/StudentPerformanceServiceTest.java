package school.faang.BJS2_32405_DoubleCache;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentPerformanceServiceTest {
    StudentPerformanceService service;
    Student John;
    Student Alice;
    Student Bob;
    Student Eva;
    Student Mike;
    Subject math;
    Subject physics;
    Subject chemistry;
    Subject literature;
    Subject history;

    @BeforeEach
    void setUp() {
        service = new StudentPerformanceService();

        John = new Student(1, "John");
        Alice = new Student(2, "Alice");
        Bob = new Student(3, "Bob");
        Eva = new Student(4, "Eva");
        Mike = new Student(5, "Mike");

        math = new Subject(1,"Math");
        physics = new Subject(2, "Physics");
        chemistry = new Subject(3, "Chemistry");
        literature = new Subject(4, "Literature");
        history = new Subject(5, "History");

        Map<Subject, Integer> johnScores = new HashMap<>();
        johnScores.put(math, 90);
        johnScores.put(physics, 85);
        service.addStudentSubjectsScores(John, johnScores);

        Map<Subject, Integer> AliceScores = new HashMap<>();
        AliceScores.put(literature, 95);
        AliceScores.put(history, 88);
        service.addStudentSubjectsScores(Alice, AliceScores);

        service.addStudentSubjectScore(Bob, math, 78);
        service.addStudentSubjectScore(Bob, literature, 81);

        service.addStudentSubjectScore(Eva, chemistry, 92);
        service.addStudentSubjectScore(Eva, physics, 89);

        service.addStudentSubjectScore(Mike, history, 85);
        service.addStudentSubjectScore(Mike, math, 80);
    }

    @Test
    @DisplayName("Adding student scores")
    void testAddStudent() {
        assertEquals(5, service.getStudentsCount());
        assertEquals(5, service.getSubjectsCount());
    }

    @Test
    @DisplayName("Removing the student from DB")
    void testRemoveStudent() {
        service.removeStudent(Eva);

        assertEquals(4, service.getStudentsCount());
        assertEquals(4, service.getSubjectsCount());
    }
}