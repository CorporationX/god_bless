package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            return executor.submit(() -> {
                int robotHp1 = robot1.getDefensePower();
                int robotHp2 = robot2.getDefensePower();
                while (true) {
                    robotHp1 -= robot2.getAttackPower();
                    if (robotHp1 <= 0) {
                        return robot2;
                    }
                    robotHp2 -= robot1.getAttackPower();
                    if (robotHp2 <= 0) {
                        return robot1;
                    }
                }
            });
        } finally {
            executor.shutdown();
            try {
                if (executor.awaitTermination(1, TimeUnit.HOURS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
