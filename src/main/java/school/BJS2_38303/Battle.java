package school.BJS2_38303;

import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private Random rand = new Random();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return service.submit(() -> {
            TreeSet<Robot> robots = new TreeSet<>();
            robots.add(robot1);
            robots.add(robot2);
            service.shutdown();
            if (robot1.sumOfAttackAndPower() == robot2.sumOfAttackAndPower()) {
                return rand.nextBoolean() ? robot1 : robot2;
            }
            return robots.last();
        });
    }
}
