package faang.school.godbless.three_wizard;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {
    private String name;
    private int year;
    private int points;

    public void solveTask(Task task) {
        this.setPoints(this.getPoints() + task.getReward());
    }
}
