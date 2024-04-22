package faang.school.godbless.StarWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService pool = Executors.newSingleThreadExecutor();

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
