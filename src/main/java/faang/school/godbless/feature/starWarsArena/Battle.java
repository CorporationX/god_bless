package faang.school.godbless.feature.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Robot> robotFuture = pool.submit(() -> robot1.attack(robot2));
        pool.shutdown();
        return robotFuture;
    }
}
