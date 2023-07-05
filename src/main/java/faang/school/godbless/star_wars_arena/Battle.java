package faang.school.godbless.star_wars_arena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Random random = new Random();
        Future<Robot> winner = executor.submit(() -> {
            boolean attackQueue = random.nextBoolean();
            while(robot1.getDefencePower() > 0 && robot2.getDefencePower() > 0) {
                if(attackQueue) {
                    robot1.attack(robot2);
                } else {
                    robot2.attack(robot1);
                }
            }
            if(robot1.getDefencePower() < 0) {
                return robot1;
            } else {
                return robot2;
            }
        });
        executor.shutdown();
        return winner;
    }
}
