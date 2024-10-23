package school.faang.triwizard.tournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public double getTotalPoints() {
        return team.stream().mapToDouble(Student::getPoints).sum();
    }

    public void getTaskReward(Task task) {
        double pointsPerStudent = task.getReward() / team.size();
        team.forEach(student -> student.increasePoints(pointsPerStudent));
    }

    @Override
    public String toString() {
        return name;
    }
}
