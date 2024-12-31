package faang.school.godbless.sprint_4.task_51091;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TournamentTest {

    private static final Student STUDENT_1 = new Student("Student_1", 5, 100);
    private static final Student STUDENT_2 = new Student("Student_2", 5, 250);

    private static final List<Student> TEAM = List.of(STUDENT_1, STUDENT_2);

    private static final School SCHOOL = new School("School", TEAM);

    private static final Task TASK = new Task("Task", 5, 50);

    Tournament tournament = new Tournament();

    @Test
    void testHoldTournament() {
        int student1Points = STUDENT_1.getPoints() + TASK.getReward();
        int student2Points = STUDENT_2.getPoints() + TASK.getReward();

        tournament.holdTournament(SCHOOL, TASK);

        assertEquals(student1Points, STUDENT_1.getPoints());
        assertEquals(student2Points, STUDENT_2.getPoints());
    }
}