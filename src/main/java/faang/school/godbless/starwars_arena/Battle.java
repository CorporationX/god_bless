package faang.school.godbless.starwars_arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Future<Robot> fight(Robot attacker, Robot defender) {
        attacker.setTarget(defender);
        defender.setTarget(attacker);

        return executorService.submit(() -> {
            while (attacker.isAlive() && defender.isAlive()) {
                attacker.attack(defender);
                if   (defender.isAlive()) {
                    defender.attack(attacker);
                }
            }

            if (attacker.isAlive()) {
                return attacker;
            } else if (defender.isAlive()) {
                return defender;
            } else {
                return null;
            }
        });
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
