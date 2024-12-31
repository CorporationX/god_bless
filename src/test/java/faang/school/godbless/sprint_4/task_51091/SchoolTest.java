package faang.school.godbless.sprint_4.task_51091;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SchoolTest {

    private static final Student STUDENT_1 = new Student("Student_1", 5, 100);
    private static final Student STUDENT_2 = new Student("Student_2", 5, 250);

    private static final List<Student> TEAM = List.of(STUDENT_1, STUDENT_2);

    private final School school = new School("School", TEAM);

    @Test
    void testGetTotalPoints() {
        int totalPoints = 0;
        for (Student student : TEAM) {
            totalPoints += student.getPoints();
        }
        assertEquals(totalPoints, school.getTotalPoints());
    }
}