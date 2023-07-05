package Multithreading.bc3041_Star_Wars_Arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Robot> winner = executorService
                .submit(() -> {
                    int res1 = robot1.getDefensePower() - robot2.getAttackPower();
                    int res2 = robot2.getDefensePower() - robot1.getAttackPower();
                    return res1 > res2 ? robot1 : robot2;
                });

        executorService.shutdown();

        return winner;
    }


}
