package faang.school.godbless.BJS214119;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Battle {

    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    private static final Random RANDOM = new Random();

    public Future<Robot> fight(Robot robot, Robot opponent) {
        return EXECUTOR.submit(() -> {
                    try {
                        System.out.println(String.format("На арене %s идет битва: %s vs %s", Thread.currentThread().getName(), robot.name(), opponent.name()));
                        var fightTime = RANDOM.nextInt(5, 15) * 1000;
                        Thread.sleep(fightTime);
                        System.out.println(String.format("Битва на арене %s закончилась %s", Thread.currentThread().getName(), fightTime));
                        return RANDOM.nextBoolean() != true ? opponent : robot;
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }

    public void shutdown() {
        EXECUTOR.shutdown();
    }
}
