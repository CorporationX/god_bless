package faang.school.godbless.BJS2_14365;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    private String name;
    private int difficulty;
    private int reward;

    public double getReward() {
        return reward + (reward * Math.log(difficulty));
    }
}
