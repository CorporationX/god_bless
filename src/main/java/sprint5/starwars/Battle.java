package sprint5.starwars;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {


    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<Robot> winner = service.submit(getRobotFightsCallable(firstRobot, secondRobot));
        service.shutdown();
        return winner;
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
