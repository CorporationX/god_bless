package faang.school.godbless.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robotFirst, Robot robotSecond) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> battle = executor.submit(() -> {
            robotFirst.setDefensePower(robotFirst.getDefensePower() - robotSecond.getAttackPower());
            robotSecond.setDefensePower(robotFirst.getDefensePower() - robotSecond.getAttackPower());
            if (robotFirst.getDefensePower() > robotSecond.getDefensePower()) {
                return robotFirst;
            } else {
                return robotSecond;
            }
        });
        executor.shutdown();
        return battle;
    }
}
