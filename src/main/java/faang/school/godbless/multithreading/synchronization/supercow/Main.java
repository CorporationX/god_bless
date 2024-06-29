package faang.school.godbless.multithreading.synchronization.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        int nThreads = 10;
        List<Player> players = List.of(
                new Player("Vasya"),
                new Player("Petya"),
                new Player("Grisha"),
                new Player("Ivan"),
                new Player("Kirill")
        );

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);

        players.forEach((player) -> executor.execute(() -> player.startBattle(boss)));

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted in awaitTermination");
        }
        executor.shutdown();
    }
}
