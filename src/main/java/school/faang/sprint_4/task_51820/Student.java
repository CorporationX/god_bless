package school.faang.sprint_4.task_51820;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Student {
    private final String name;
    private final int year;
    private int points;

    public void addPoints(int rewardPoints) {
        points += rewardPoints;
    }
}
