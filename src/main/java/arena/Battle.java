package arena;

import lombok.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int POOL_SIZE = 10;
    private final ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);

    public Future<Robot> fight(@NonNull Robot robot1, @NonNull Robot robot2) {
        return executor.submit(() -> {
            int robot1Attack = robot1.getDefensePower() - robot2.getAttackPower();
            int robot2Attack = robot1.getDefensePower() - robot2.getAttackPower();
            if (robot1Attack > robot2Attack) {
                return robot1;
            }
            if (robot2Attack > robot1Attack) {
                return robot2;
            }
            return null;
        });
    }

    public void endBattle() {
        executor.shutdown();
    }
}
