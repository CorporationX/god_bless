package sprint5.starwars;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final ExecutorService SERVICE = Executors.newFixedThreadPool(1);

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return SERVICE.submit(getRobotFightsCallable(firstRobot, secondRobot));
    }

    public void shutdownBattle() {
        SERVICE.shutdown();
    }

    private Callable<Robot> getRobotFightsCallable(Robot firstRobot, Robot secondRobot) {
        return () -> {
            while (firstRobot.getHealth() != 0 && secondRobot.getHealth() != 0) {
                firstRobot.attack(secondRobot);

                if (secondRobot.getHealth() != 0) {
                    secondRobot.attack(firstRobot);
                }
            }
            return firstRobot.getHealth() == 0 ? secondRobot : firstRobot;
        };
    }
}
