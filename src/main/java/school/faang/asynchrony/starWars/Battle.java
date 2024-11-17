package school.faang.asynchrony.starWars;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final int NUMBER_OF_THREADS = 2;
    private final Random rn = new Random();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        return service.submit(() -> {
            if (getDifference(robot1) > getDifference(robot2)) {
                return robot1;
            } else if (getDifference(robot1) < getDifference(robot2)) {
                return robot2;
            } else {
                return rn.nextBoolean() ? robot1 : robot2;
            }
        });
    }

    public int getDifference(Robot robot) {
        return robot.getAttackPower() - robot.getDefensePower();
    }

}
