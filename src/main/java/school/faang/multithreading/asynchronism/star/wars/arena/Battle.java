package school.faang.multithreading.asynchronism.star.wars.arena;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> future = executor.submit(() -> {
            log.info("Начинается битва роботов");
            int powerFirstRobot = Math.abs(robot1.getAttackPower() - robot2.getDefensePower());
            int powerSecondRobot = Math.abs(robot2.getAttackPower() - robot1.getDefensePower());
            return powerFirstRobot >= powerSecondRobot ? robot1 : robot2;
        });
        executor.shutdown();
        return future;
    }
}
