package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
            return EXECUTOR.submit(() -> {
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
    }
}
