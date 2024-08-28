package BJS2_24875_ThreeWizzardTournament;

import lombok.Data;

import java.util.List;

@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Student student : team) {
            totalPoints += student.getPoints();
        }
        return totalPoints;
    }
}
