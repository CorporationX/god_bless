package faang.school.godbless.multithreading.async_future.Star_wars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private ExecutorService executorService;

    public Battle() {
        executorService = Executors.newCachedThreadPool();
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        return executor.submit(() -> {
            while (true) {
                robot1.attack(robot2);
                if (robot2.getDefensePower() <= 0) return robot1;
                robot2.attack(robot1);
                if (robot1.getDefensePower() <= 0) return robot2;
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
