package school.faang.starWarsArena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final ExecutorService service = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return service.submit(() -> {
            int powerRobot1 =
                    robot1.getAttackPower() + robot1.getDefensePower();
            int powerRobot2 =
                    robot2.getAttackPower() + robot2.getDefensePower();
            if (powerRobot1 > powerRobot2) {
                return robot1;
            } else if (powerRobot2 > powerRobot1) {
                return robot2;
            } else {
                return Math.random() > 0.5 ? robot1 : robot2;
            }
        });
    }

    public void serviceShutdown() {
        service.shutdown();
    }
}
