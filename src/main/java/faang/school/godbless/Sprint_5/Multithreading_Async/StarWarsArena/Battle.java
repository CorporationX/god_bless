package faang.school.godbless.Sprint_5.Multithreading_Async.StarWarsArena;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public Future<Robot> fight (Robot robot1, Robot robot2) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Robot> winner = executor.submit(() -> {
            int firstPower = robot1.getAttackPower() + robot1.getDifencePower();
            int secondPower = robot2.getAttackPower() + robot2.getDifencePower();

            if (firstPower > secondPower) return robot1;
            if (firstPower < secondPower) return robot2;
            List<Robot> robots = List.of(robot1, robot2);
            int rand = new Random().nextInt(0, 2);
            return robots.get(rand);
        });

        return winner;
    }
}
