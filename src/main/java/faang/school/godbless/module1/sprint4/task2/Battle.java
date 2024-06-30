package faang.school.godbless.module1.sprint4.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private final ExecutorService service;

    public Battle() {
        this.service = Executors.newCachedThreadPool();
    }


    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        return service.submit(() -> callWinner(firstRobot, secondRobot));
    }

    public void shutdownAllThreads(){
        service.shutdown();
    }

    public Robot callWinner(Robot firstRobot, Robot secondRobot) {
        if (firstRobot.getAttackPower() + firstRobot.getDefencePower()
                > secondRobot.getAttackPower() + secondRobot.getDefencePower()) {
            return firstRobot;
        } else {
            return secondRobot;
        }
    }
}
