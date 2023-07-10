package faang.school.godbless.spring_4.star_wars_arena;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {
    public final ExecutorService pool = Executors.newFixedThreadPool(2);

    public Future<Robot> fight(Robot robot1, Robot robot2) {
        return pool.submit(() -> (new Random().nextInt(1, 3) == 1) ? robot1 : robot2);
    }
}
