package bjs2_37884;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Student {
    private String name;
    private int year;
    @Getter
    private int points;

    public void getTaskReward(Task task) {
        points += task.getReward();
    }
}
