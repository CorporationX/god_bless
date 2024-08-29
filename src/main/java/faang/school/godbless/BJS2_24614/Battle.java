package faang.school.godbless.BJS2_24614;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    private final int ROBOTS_COUNT = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(ROBOTS_COUNT);

    public Future<Robot> fight(Robot robot, Robot opponent) {
        Future<Robot> winner = executor.submit(() -> {
            System.out.println("Battle started");

            TimeUnit.SECONDS.sleep(5);

            if (robot.getTotalPower() > opponent.getTotalPower()) {
                return robot;
            } else if (robot.getTotalPower() < opponent.getTotalPower()) {
                return opponent;
            } else {
                return new Robot("Ничья", 0, 0);
            }
        });

        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Battle finished");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Battle interrupted");
            throw new RuntimeException(e);
        }

        return winner;
    }
}
