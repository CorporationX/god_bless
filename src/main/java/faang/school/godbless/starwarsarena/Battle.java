package faang.school.godbless.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    Random random = new Random();
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        Future<Robot> winnerFuture = executorService.submit(() -> {
            Thread.sleep(1000 + random.nextInt(4000));
            return robot1.getAttackPower() + robot1.getDefensePower() >
                    robot2.getAttackPower() + robot2.getDefensePower() ? robot1 : robot2;
        });

        return  winnerFuture;
    }
}
