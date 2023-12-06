package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return executorService.submit(() -> robot1.getAttackPower() + robot1.getDefensePower()
                > robot2.getAttackPower() + robot2.getDefensePower()
                ? robot1 : robot2);
    }
}
