package school.faang.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(2);
        Player sasha = new Player("Sasha");
        Player ivan = new Player("Ivan");
        Player petr = new Player("Petr");
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List.of(sasha, ivan, petr).forEach((player) -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
