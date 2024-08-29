package faang.school.godbless.sprint4.star_wars;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Battle {
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final Random generator = new Random();

    public Future<Robot> fight(Robot r1, Robot r2) {
        int idx = generator.nextInt(4);
        return executor.submit(() -> {
            try {
                Thread.sleep(1000 * idx);
            } catch(InterruptedException e) {
                System.out.println();
            }
            return idx < 2 ? r1 : r2;
        });


    }
}
