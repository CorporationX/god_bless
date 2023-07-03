package Sprint_4_1_Task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        var winnerFuture = executorService.submit(() -> {
            if (robot1.getAttackPower() + robot1.getDefensePower() > robot2.getDefensePower() + robot2.getAttackPower()) {
                return robot1;
            }
            return robot2;
        });
        executorService.shutdown();
        return winnerFuture;
    }
}
