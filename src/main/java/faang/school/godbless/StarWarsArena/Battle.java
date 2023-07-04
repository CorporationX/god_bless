package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Robot> robotFuture = executor.submit(() -> {
            if (robot1.getAttackPower() - robot2.getDefensePower() > robot2.getAttackPower() - robot1.getDefensePower()) {
                return robot1;
            }
            return robot2;
        });
        return robotFuture;
    }
}
