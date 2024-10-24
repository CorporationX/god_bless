package school.faang.starwars_arena.main_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int THREAD_COUNT = 4;
    private ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        Future<Robot> winner = service.submit(() -> {
            int power1 = robot1.getAttackPower() + robot1.getDefencePower();
            int power2 = robot2.getAttackPower() + robot2.getDefencePower();

            if (power1 > power2) {
                return robot1;
            } else if (power2 > power1) {
                return robot2;
            } else {
                return Math.random() > 0.5 ? robot1 : robot2;
            }
        });

        return winner;
    }

    public void shutdown() {
        service.shutdown();
    }
}
