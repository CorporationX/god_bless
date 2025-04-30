package school.faang.harry_potter;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class School {
    private final String name;
    private final List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int totalPoints) {
        int pointsPerStudent = totalPoints / team.size();
        team.forEach(student -> student.addPoints(pointsPerStudent));
    }
}
