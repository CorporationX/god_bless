package faang.school.godbless.sprint5.starWarsArena.classes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private static final int NUM_THREAD = 3;
    public static ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

    public Future<Robot> fight(Robot redRobot, Robot blueRobot) {
        return executor.submit(() -> getWinner(redRobot, blueRobot));
    }

    private Robot getWinner(Robot redRobot, Robot blueRobot) {
        while (redRobot.getHealth() > 0 && blueRobot.getHealth() > 0) {
            redRobot.attack(blueRobot);
            blueRobot.attack(redRobot);
        }
        if (redRobot.getHealth() > 0) {
            return redRobot;
        } else {
            return blueRobot;
        }
    }

    public void endBattle() {
        executor.shutdown();
    }
}
