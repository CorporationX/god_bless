package faang.school.godbless.starwarsarena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot firstRobot, Robot secondRobot) {
        Random rnd = new Random();
        return executorService.submit(() -> rnd.nextBoolean() ? firstRobot : secondRobot);
    }
}
