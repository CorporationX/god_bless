package school.faangSprint4.t07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService executor;
    private static final int THREADS = 3;
    private static final int SLEEP_TIME = 1000;
    private static final double PERCENTS = 0.5;

    public Battle() {
        this.executor = Executors.newFixedThreadPool(THREADS);
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int power1 = robot1.attackPower() + robot1.defensePower();
            int power2 = robot2.attackPower() + robot2.defensePower();
            Thread.sleep(SLEEP_TIME);
            if (power1 > power2) {
                return robot1;
            } else if (power2 > power1) {
                return robot2;
            } else {
                return Math.random() > PERCENTS ? robot1 : robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}