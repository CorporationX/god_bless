package faang.school.godbless.BJS2_24614;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    private static final int ROBOTS_COUNT = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(ROBOTS_COUNT);

    public Future<Robot> fight(Robot robot, Robot opponent) {
        return executor.submit(() -> {
            System.out.println("Battle started");

            TimeUnit.SECONDS.sleep(5);

            System.out.println("Battle finished");

            if (robot.getTotalPower() > opponent.getTotalPower()) {
                return robot;
            } else if (robot.getTotalPower() < opponent.getTotalPower()) {
                return opponent;
            } else {
                return null;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("All threads terminated");
            } else {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Battle interrupted");
            throw new RuntimeException(e);
        }
    }
}
