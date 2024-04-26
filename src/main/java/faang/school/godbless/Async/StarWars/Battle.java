package faang.school.godbless.Async.StarWars;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        CompletableFuture<Robot> future = CompletableFuture.supplyAsync(() -> {
            try {
                while (robot1.getDefensePower() > 0 && robot2.getDefensePower() > 0) {
                    robot2.setDefensePower(robot2.getDefensePower() - robot1.getAttackPower());
                    robot1.setDefensePower(robot1.getDefensePower() - robot2.getAttackPower());

                    Thread.sleep(1000);
                }
                return robot1.getDefensePower() > 0 ? robot1 : robot2;

            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        });
        return future;
    }

}
