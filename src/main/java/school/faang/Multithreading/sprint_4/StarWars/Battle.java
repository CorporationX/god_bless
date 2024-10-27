package school.faang.Multithreading.sprint_4.StarWars;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public static final int THREAD_POOL = 10;
    public static final Random random = new Random();

    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        Future<Robot> robotFuture = executor.submit(() -> {
            int powerRobot1 = robot1.getAttackPower() + robot1.getDefensePower();
            int powerRobot2 = robot2.getAttackPower() + robot2.getDefensePower();

            if (powerRobot1 > powerRobot2) {
                return robot1;
            } else if (robot1.getAttackPower() + robot1.getDefensePower() == robot2.getAttackPower() + robot2.getDefensePower()) {
                List<Robot> robots = Arrays.asList(robot1, robot2);
                int randRob = random.nextInt(robots.size());
                return robots.get(randRob);
            } else {
                return robot2;
            }
        });

        return robotFuture;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
