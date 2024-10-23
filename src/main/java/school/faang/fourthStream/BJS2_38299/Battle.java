package school.faang.fourthStream.BJS2_38299;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    private static final long TERMINATION_SECONDS = 20;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int power1 = robot1.getTotalPower(robot1);
            int power2 = robot2.getTotalPower(robot2);

            if (power1 > power2) {
                return robot1;
            } else if (power2 > power1) {
                return robot2;
            } else {
                return Math.random() > 0.5 ? robot1 : robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TERMINATION_SECONDS, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.warn("Поток был прерван", e);
            Thread.currentThread().interrupt();
        }
    }
}
