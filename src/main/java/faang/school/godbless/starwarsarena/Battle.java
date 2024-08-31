package faang.school.godbless.starwarsarena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int robot1Score = robot1.getAttackPower() - robot2.getDefensePower();
            int robot2Score = robot2.getAttackPower() - robot1.getDefensePower();

            if (robot1Score > robot2Score) {
                return robot1;
            }
            if (robot1Score < robot2Score) {
                return robot2;
            }
            return robot1.getAttackPower() >= robot2.getAttackPower() ? robot1 : robot2;
        });
    }

    public static void shutdown() {
        executor.shutdown();
    }
}

