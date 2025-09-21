package school.faang.multithreading.synchronize.bjs2_90314;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        Object lock = new Object();
        Boss boss = new Boss(lock);

        Player oleg = new Player("Oleg");
        Player ivan = new Player("Ivan");
        Player nikolay = new Player("Nikolay");
        Player grisha = new Player("Grisha");

        List<Player> players = new ArrayList<>(Arrays.asList(oleg, ivan, nikolay, grisha));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (Player player : players) {
            executorService.execute(() -> player.doBattle(boss));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}