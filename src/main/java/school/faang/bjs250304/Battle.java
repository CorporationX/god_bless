package school.faang.bjs250304;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {

    private static final int NUMBER_OF_THREADS = 4;
    private static final int AWAIT_DELAY = 1;
    ExecutorService pool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public Future<Robot> fight(Robot firsRobot, Robot secondRobot) {
        return pool.submit(() -> {
            int firstRobotPower = firsRobot.getAttackPower() + firsRobot.getDefensePower();
            int secondRobotPower = secondRobot.getAttackPower() + secondRobot.getDefensePower();

            if (firstRobotPower > secondRobotPower) {
                return firsRobot;
            } else if (firstRobotPower < secondRobotPower) {
                return secondRobot;
            } else {
                return Math.random() < 0.5 ? firsRobot : secondRobot;
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
