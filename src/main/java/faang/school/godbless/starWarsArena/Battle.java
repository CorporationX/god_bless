package faang.school.godbless.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int NUM_THREADS = 10;
    private final ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

    public Future<Robot> fight(Robot first, Robot second) {
        Future<Robot> winner = pool.submit(() -> {
            int firstDamage = second.getDefensePower() - first.getAttackPower();
            int secondDamage =  first.getDefensePower() - second.getAttackPower();
            return firstDamage > secondDamage ? first : second;
        });
        pool.shutdown();
        return winner;
    }
}
