package faang.school.godbless.starWars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Robot> future = executorService.submit(() -> {
            while (robot1.getHealth() > 0 && robot2.getHealth() > 0) {
                System.out.println("Health: " + robot1.getHealth() + " / " + robot2.getHealth());
                robot1.attack(robot2);
                robot2.attack(robot1);
            }
            if (robot1.getHealth() <= 0) {
                return robot2;
            } else {
                return robot1;
            }
        });
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        return future;
    }
}
