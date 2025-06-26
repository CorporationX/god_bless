package school.faang.sprint3.bjs2_82803;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class School {
    private String name;
    private List<Student> team;

    public School completeTask(Task task) {
        team.forEach(student -> student.changePoints(task.getReward()));
        return this;
    }

    public int getTotalPoints() {
        return team.stream().mapToInt(Student::getPoints).sum();
    }
}
