package school.faang.starwars;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final double PROBABILITY_OF_WINNING = 0.5;
    private static final int THREAD_COUNT_SIZE = 8;

    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT_SIZE);

    public Future<Robot> fight(Robot first, Robot second) {
        return executor.submit(() -> {
            int firstAttack = first.getAttackPower() - second.getDefensePower();
            int secondAttack = second.getAttackPower() - first.getDefensePower();
            if (firstAttack > secondAttack) {
                return first;
            } if (firstAttack < secondAttack) {
                return second;
            } else {
                return Math.random() > PROBABILITY_OF_WINNING ? first : second;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }
}
