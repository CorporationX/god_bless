package faang.school.godbless.star_wars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    ExecutorService executor = Executors.newSingleThreadExecutor();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {

            int robot1Power = robot1.getDefensePower();
            int robot2Power = robot2.getDefensePower();

            while (robot1Power > 0 && robot2Power > 0) {
                robot1Power -= robot2.getAttackPower();
                robot2Power -= robot1.getAttackPower();
            }
            return robot1Power > robot2Power ? robot1 : robot2;

        });
    }
}
