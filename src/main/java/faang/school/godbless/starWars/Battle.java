package faang.school.godbless.starWars;

import java.util.concurrent.*;

public class Battle {
    private final ExecutorService executor;

    public Battle() {
        executor = Executors.newCachedThreadPool();
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return executor.submit(() -> {
            int powerDifference = robot1.attackPower() - robot2.defensePower();
            if (powerDifference > 0) {
                System.out.println(robot1.name() + " wins the battle!");
                return robot1;
            } else if (powerDifference < 0) {
                System.out.println(robot2.name() + " wins the battle!");
                return robot2;
            } else {
                System.out.println("It's a tie! " + robot1.name() + " wins the battle!");
                return robot1;
            }
        });
    }

    public void shutdown() {
        executor.shutdown();
    }

}
