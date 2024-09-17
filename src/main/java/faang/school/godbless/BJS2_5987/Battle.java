package faang.school.godbless.BJS2_5987;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    // а как в таком случае пректратить выполнение Executors?
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorFight = Executors.newSingleThreadExecutor();
        return executorFight.submit(() -> {
            while (robot1.getDefensePower() > 0 || robot2.getDefensePower() > 0) {
                robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());
                robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());
            }
            if (robot1.getDefensePower() > robot2.getDefensePower()) {
                return robot1;
            } else {
                return robot2;
            }
        });
    }
}
