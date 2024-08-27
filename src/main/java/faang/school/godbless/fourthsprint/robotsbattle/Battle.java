package faang.school.godbless.fourthsprint.robotsbattle;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int NUM_BATTLES = 3;

    private final ExecutorService executor = Executors.newFixedThreadPool(NUM_BATTLES);
    private final Random random = new Random();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int comparison = robot1.getPower() - robot2.getPower();
            if (comparison == 0) {
                return random.nextBoolean() ? robot1 : robot2;
            } else {
                return comparison > 0 ? robot1 : robot2;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
