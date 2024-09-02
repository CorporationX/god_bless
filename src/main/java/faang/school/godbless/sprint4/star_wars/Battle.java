package faang.school.godbless.sprint4.star_wars;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static final long INACTIVITY_TIMEOUT = 7;
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    private final ThreadLocalRandom generator = ThreadLocalRandom.current();
    private ScheduledFuture<?> shutdownTask;

    public Battle() {
        resetShutdownTask();
    }

    public Future<Robot> fight(Robot r1, Robot r2) {
        return executor.schedule(() -> {
            int idx = generator.nextInt(4);
            try {
                Thread.sleep(idx * 1000);
            } catch(InterruptedException e) {
                throw new RuntimeException("Fight task was interrupted!");
            }
            return idx < 2 ? r1 : r2;
        }, 0, TimeUnit.SECONDS);
    }

    private void resetShutdownTask() {
        if (shutdownTask != null) {
            shutdownTask.cancel(false);
        }

        shutdownTask = executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Shutting down executor due to inactivity...");
        }, INACTIVITY_TIMEOUT, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot r2d2 = new Robot("R2-D2", 2, 2);
        Robot c2po = new Robot("C-2PO", 2, 2);

        Robot r3d3 = new Robot("R3-D3", 3, 3);
        Robot c3po = new Robot("C-3PO", 3, 3);

        Robot r4d4 = new Robot("R4-D4", 4, 4);
        Robot c4po = new Robot("C-4PO", 4, 4);

        Future <Robot> future1 = battle.fight(r2d2, c2po);
        Future <Robot> future2 = battle.fight(r3d3, c3po);
        Future <Robot> future3 = battle.fight(r4d4, c4po);

        List<Future<Robot>> futures = List.of(future1, future2, future3);

        while(!futures.stream().allMatch(Future::isDone)) {
        // do something...
        }
        futures.forEach(f -> {
            try {
                System.out.printf("Winner: %s%n", f.get());
            } catch(InterruptedException | ExecutionException e) {
                throw new RuntimeException("Something went wrong during the battle!");
            }
        });
    }
}
