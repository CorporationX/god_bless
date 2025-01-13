package school.faang.task_51709;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }

    public void addPointsToTeam(int points) {
        for (Student student : team) {
            student.addPoints(points);
        }
    }
}
