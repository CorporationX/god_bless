package faang.school.godbless.async.task_5.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
@Getter
@AllArgsConstructor
public class Student {
    private static final Random RANDOM = new Random();
    private static final long MIN_WAITING_TIME = 1000;
    private final String name;
    private int year;
    private int points;
    private boolean busy;

    public void earnPoints(int addingPoints) {
        points += addingPoints;
    }

    public synchronized void startTask(Task task) {
        if (!busy) {
            busy = true;
            System.out.println(name + " начал испытание " + task.getName());
            try {
                Thread.sleep(MIN_WAITING_TIME * (task.getDifficulty() + 1));
                boolean isPassed = RANDOM.nextBoolean();
                if (isPassed) {
                    System.out.println(name + " прошел испытание " + task.getName() + " и получает " + task.getReward() + " очков");
                    earnPoints(task.getReward());
                    finishTask();
                } else {
                    System.out.println(name + " не смог пройти испытание " + task.getName());
                    finishTask();
                }
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void finishTask() {
        busy = false;
    }
}