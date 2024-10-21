package school.faang.threeMagiciansTournament;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private final String name;
    private int year;
    private int points;

    public void applyReward(Task task) {
        points += task.getReward();
    }
}
