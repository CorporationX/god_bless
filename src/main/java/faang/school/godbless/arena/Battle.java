package faang.school.godbless.arena;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    ExecutorService executor = Executors.newCachedThreadPool();

    public Future<Robot> fight(Robot robotOne, Robot robotTwo) {
        return executor.submit(() -> {
            int v = robotOne.getDefensePower() - robotTwo.getAttackPower() +  (int) (Math.random() * 10);
            int v1 = robotTwo.getDefensePower() - robotOne.getAttackPower() + (int) (Math.random() * 10);
            return v >= v1 ? robotOne : robotTwo ;
        });
    }
}
