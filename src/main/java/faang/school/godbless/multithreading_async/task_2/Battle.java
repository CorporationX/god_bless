package faang.school.godbless.multithreading_async.task_2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final Random RANDOM = new Random();
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return EXECUTOR.submit(() -> determineBattleWinner(firstRobot, secondRobot));
    }

    private Robot determineBattleWinner(Robot firstRobot, Robot secondRobot) {
        if (firstRobot.getSumPower() > secondRobot.getSumPower()) {
            return firstRobot;
        } else if (firstRobot.getSumPower() < secondRobot.getSumPower()) {
            return secondRobot;
        } else {
            return RANDOM.nextBoolean() ? firstRobot : secondRobot;
        }
    }

    public void shutdown() {
        EXECUTOR.shutdown();
    }
}
