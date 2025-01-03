package school.faang.sprint_4.task_51178;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        int totalPoints = 0;

        for (Student student : team) {
            totalPoints += student.getPoints();
        }

        return totalPoints;
    }

    public void updatePoints(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
