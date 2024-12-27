package school.faang.taks_50295;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot first, Robot second) {
        return executor.submit(() -> {
            int powerOfFirst = first.getAttackPower() + first.getDefencePower();
            int powerOfSecond = second.getAttackPower() + second.getDefencePower();

            if (powerOfFirst >= powerOfSecond) {
                return first;
            } else {
                return second;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
