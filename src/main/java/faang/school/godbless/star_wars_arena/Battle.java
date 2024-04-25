package faang.school.godbless.star_wars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int THREAD_POOL_SIZE = 2;

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        return executorService.submit(() -> {
            while (robot1.getDefensePower() > 0 && robot2.getDefensePower() > 0) {
                robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());
                robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
            }

            executorService.shutdown();

            if (robot1.getDefensePower() > robot2.getDefensePower()) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }
}