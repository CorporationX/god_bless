package school.faang.task_bjs251636;

import lombok.Data;

@Data
public class Student {
    private final String name;
    private final int course;
    private int points = 0;

    public void addPoints(int rewardPoints) {
        points += rewardPoints;
    }
}
