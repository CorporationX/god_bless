package sprint_4.sprint_4_1_async_future.starWarsArena_38342;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Battle {
    private final static int COUNT_THREAD_POOL = 5;
    private final static int TIME_FIGHTING = 1000;
    private final static int TIME_TERMINATION = 60;

    private final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD_POOL);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int power1 = robot1.getAttackPower() + robot1.getDefensePower();
            int power2 = robot2.getAttackPower() + robot2.getDefensePower();

            Thread.sleep(TIME_FIGHTING);
            if (power1 > power2) {
                return robot1;
            }
            if (power2 > power1) {
                return robot2;
            }
            return Math.random() > 0.5 ? robot1 : robot2;
        });
    }

    public void shutdown() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_TERMINATION, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Error: {}", e.getMessage());
        }
    }
}
