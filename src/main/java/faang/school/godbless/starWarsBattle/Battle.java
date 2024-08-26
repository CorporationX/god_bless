package faang.school.godbless.starWarsBattle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Battle {

    public Future<Robot> fight(Robot attacker, Robot defender) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> winner = executorService.submit(() -> {
            if (attacker.attackPower() > defender.defensePower()) {
                return attacker;
            } else if (attacker.attackPower() < defender.defensePower()) {
                return defender;
            } else {
                return ThreadLocalRandom.current().nextInt(2) == 0 ? attacker : defender;
            }
        });
        executorService.shutdown();

        return winner;
    }
}
