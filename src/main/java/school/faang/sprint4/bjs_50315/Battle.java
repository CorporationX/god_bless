package school.faang.sprint4.bjs_50315;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Battle {
    private static final int THREADS_AMOUNT = 3;
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private final ExecutorService executor;

    public Battle() {
        this.executor = Executors.newFixedThreadPool(THREADS_AMOUNT);
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int robot1TotalPower = robot1.attackPower() + robot1.defensePower();
            int robot2TotalPower = robot2.attackPower() + robot2.defensePower();

            if (robot1TotalPower > robot2TotalPower) {
                return robot1;
            } else if (robot2TotalPower > robot1TotalPower) {
                return robot2;
            } else {
                return RANDOM.nextInt() > 0.5 ? robot1 : robot2;
            }
        });
    }
}
