package sprint5.tournament;

import lombok.Data;

import java.util.Random;

@Data
public class Student {
    private static final Random COMPLETION_RATE = new Random();
    private static final int MAX_SUCCESS_RATE = 10;

    private final String name;
    private final int year;
    private int points;

    public void completeTask(Task task) {
        onTask();
        if (task.difficulty() <= (COMPLETION_RATE.nextInt(MAX_SUCCESS_RATE) + 1)) {
            System.out.printf("%s got %d points for completing the task!\n", name, task.reward());
            points += task.reward();
        } else {
            System.out.printf("%s failed the task %s\n", name, task.name());
        }
    }

    private void onTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
