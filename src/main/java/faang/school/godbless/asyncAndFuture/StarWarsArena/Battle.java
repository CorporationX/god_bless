package faang.school.godbless.asyncAndFuture.StarWarsArena;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Getter
@AllArgsConstructor
public class Battle {
    private final int NUMBER_THREADS = 4;
    private final Random random = new Random();

    private ExecutorService executorService;

    public Battle() {
        this.executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
    }

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        System.out.printf("Начало битвы между %s и %s\n", robot1.getName(), robot2.getName());
        Future<Robot> result = executorService.submit(() -> determineTheWinner(robot1, robot2));
        executorService.shutdown();
        return result;
    }

    private Robot determineTheWinner(Robot robot1, Robot robot2) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (robot1.getAttackPower() > robot2.getDefensePower() && robot2.getAttackPower() < robot1.getDefensePower())
            return robot1;
        if (robot2.getAttackPower() > robot1.getDefensePower() && robot1.getAttackPower() < robot2.getDefensePower())
            return robot2;

        if (random.nextBoolean())
            return robot1;
        else
            return robot2;
    }
}
