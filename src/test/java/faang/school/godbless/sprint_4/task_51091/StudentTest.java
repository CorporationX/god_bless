package faang.school.godbless.sprint_4.task_51091;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {

    private static final Student STUDENT = new Student("Student", 5, 200);

    private static final int POINTS = 100;

    @Test
    void testAddPoints() {
        int studentPoints = STUDENT.getPoints() + POINTS;
        STUDENT.addPoints(POINTS);
        assertEquals(studentPoints, STUDENT.getPoints());
    }
}