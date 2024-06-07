package star_wars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> winnerFuture = executor.submit(() -> {
            return robot1.getDefensePower() - robot2.getAttackPower() > robot2.getDefensePower() - robot1.getAttackPower() ? robot1 : robot2;
        });
        executor.shutdown();
        return winnerFuture;
    }
}
