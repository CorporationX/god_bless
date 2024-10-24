package school.faang.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int NUM_THREADS = 5;
    private final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            try {
                Thread.sleep(3_000);
                int power1 = robot1.sumPower();
                int power2 = robot2.sumPower();
                if (power1 > power2) {
                    return robot1;
                } else if (power1 < power2) {
                    return robot2;
                } else {
                    return Math.random() > 0.5 ? robot1 : robot2;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                throw new IllegalStateException("Fight got interrupted.");
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}