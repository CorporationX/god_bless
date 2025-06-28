package school.faang.bjs2_82479;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static final double PROBABILITY_ROBOT_1_WIN = 0.5;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Robot> fight(Robot robotRedCorner, Robot robotBlueCorner) {
        return executor.submit(() -> {
            int robotRedCornerPower = robotRedCorner.getAttackPower() + robotRedCorner.getDefensePower();
            int robotBlueCornerPower = robotBlueCorner.getAttackPower() + robotBlueCorner.getDefensePower();

            if (robotRedCornerPower > robotBlueCornerPower) {
                return robotRedCorner;
            } else if (robotBlueCornerPower > robotRedCornerPower) {
                return robotBlueCorner;
            } else {
                return Math.random() > PROBABILITY_ROBOT_1_WIN ? robotRedCorner : robotBlueCorner;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
    }
}
