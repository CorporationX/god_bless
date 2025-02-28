package school.faang.BJS2_64913;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    ExecutorService executor = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        if (robot1 == null || robot2 == null) {
            throw new IllegalArgumentException("Robots не должны быть null");
        }
        Future<Robot> future = executor.submit(() -> {
            int sumPowerRobot1 = robot1.getAttackPower() + robot1.getDefensePower();
            int sumPowerRobot2 = robot2.getAttackPower() + robot2.getDefensePower();

            if (sumPowerRobot1 > sumPowerRobot2) {
                return robot1;
            } else if (sumPowerRobot1 < sumPowerRobot2) {
                return robot2;
            } else {
                return ThreadLocalRandom.current().nextBoolean() ? robot1 : robot2;
            }
        });

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Executor был прерван", e);
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        return future;
    }
}