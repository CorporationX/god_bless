package faang.school.godbless.multithreading_2.starwars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Robot> future = executor.submit(() -> {
            List<Robot> robots = new ArrayList<>(List.of(robot1, robot2));
            Random random = new Random();
            while (robot1.isAlive() && robot2.isAlive()) {
                int indexWhoAttack = random.nextInt(robots.size());
                robots.get(robots.size() - indexWhoAttack - 1).getDamage(robots.get(indexWhoAttack).attack());
            }

            if (robot1.isAlive()) {
                System.out.println(robot2.getName() + " мёртв");
                return robot1;
            } else {
                System.out.println(robot1.getName() + " мёртв");
                return robot2;
            }
        });

        executor.shutdown();
        return future;
    }
}
