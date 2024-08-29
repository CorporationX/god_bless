package faang.school.godbless.BJS2_24785;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;

    public int getRewardPoints() {
        return reward * difficulty;
    }
}
