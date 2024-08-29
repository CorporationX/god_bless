package faang.school.godbless.BJS2_24670;

import lombok.AllArgsConstructor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Battle {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();
    private ExecutorService executor;

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            System.out.println(robot1.getName() + " vs " + robot2.getName());

            int robot1Power = RANDOM.nextInt(1, robot1.getAttackPower()) + RANDOM.nextInt(1, robot1.getDefensePower());
            Thread.sleep(robot1Power * 500L);
            int robot2Power = RANDOM.nextInt(1, robot2.getAttackPower()) + RANDOM.nextInt(1, robot2.getDefensePower());
            Thread.sleep(robot2Power * 500L);

            return robot1Power > robot2Power ? robot1 : robot2;
        });
    }
}
