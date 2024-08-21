package BJS2_24139_Supercow;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_LIMIT = 5;
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player("Max"), new Player("Dima"), new Player("Sergey"),
                new Player("Varya"), new Player("Sabina"));

        Boss grizzly = new Boss(4, 2);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_LIMIT);

        for (Player player : players) {
            executor.execute(() -> player.startBattle(grizzly));
        }

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
            executor.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
