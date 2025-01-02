package school.faang.task_51119;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class School {
    private String name;
    private List<Student> team;

    public School(String name, List<Student> team) {
        if (name.isEmpty() || team.isEmpty()) {
            throw new IllegalArgumentException("Params cannot be empty");
        }
        this.name = name;
        this.team = team;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        int pointsPerStudent = points / team.size();
        team.forEach(student -> student.addPoints(pointsPerStudent));
    }
}
