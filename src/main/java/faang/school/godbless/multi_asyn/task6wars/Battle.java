package faang.school.godbless.multi_asyn.task6wars;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    Random random = new Random();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executorService.submit(() -> {
            Thread.sleep(1000 + random.nextInt(5000));

            return robot1.getAttackPower() * robot1.getDefenderPower() >
                    robot2.getAttackPower() * robot2.getDefenderPower() ? robot1 : robot2;
        });
    }

    public void endBattle() {
        executorService.shutdown();
    }
}
