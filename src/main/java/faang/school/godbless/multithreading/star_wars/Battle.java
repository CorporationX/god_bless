package faang.school.godbless.multithreading.star_wars;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final Random random;

    public Battle() {
        random = new Random();
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Robot> winner = executor.submit(() -> {
            int robot1TotalPower = robot1.getAttackPower() + robot1.getDefencePower();
            int robot2TotalPower = robot2.getAttackPower() + robot2.getDefencePower();

            try {
                Thread.sleep(random.nextInt(1000, 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (robot1TotalPower > robot2TotalPower) {
                return robot1;
            } else if (robot2TotalPower > robot1TotalPower) {
                return robot2;
            } else {
                return List.of(robot1, robot2).get(random.nextInt(2));
            }
        });

        executor.shutdown();
        return winner;
    }
}
