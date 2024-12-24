package school.faang.sprint_4.task_50246;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int AWAIT_DELAY = 1;
    private static final ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return pool.submit(() -> {
            int firstRobotPower = firstRobot.attackPower() + firstRobot.defensePower();
            int secondRobotPower = secondRobot.attackPower() + secondRobot.defensePower();

            if (firstRobotPower > secondRobotPower) {
                return firstRobot;
            } else if (firstRobotPower < secondRobotPower) {
                return secondRobot;
            } else {
                return Math.random() < 0.5 ? firstRobot : secondRobot;
            }
        });
    }

    public void shutdown() {
        pool.shutdown();

        try {
            if (!pool.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted. Shutting down...");
            pool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
