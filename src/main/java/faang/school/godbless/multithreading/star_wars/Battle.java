package faang.school.godbless.multithreading.star_wars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private ExecutorService executor;

    public Battle() {
        this.executor = Executors.newCachedThreadPool();
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            TimeUnit.SECONDS.sleep(2);
            while (0 < robot1.getDefensePower() && robot2.getDefensePower() > 0) {
                robot1.attack(robot2);
                robot2.attack(robot1);
            }
            if (0 < robot1.getDefensePower()) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }

    public void endBattle() {
        executor.shutdown();
    }
}
