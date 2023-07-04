package faang.school.godbless.star.wars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Robot> robotFuture = executorService.submit(() -> {
            System.out.println("Сражение началось");
            if (robot1.getAttackPower() >= robot2.getDefensePower()) {
                return robot1;
            } else {
                return robot2;
            }
        });
        executorService.shutdown();
        return robotFuture;
    }
}
