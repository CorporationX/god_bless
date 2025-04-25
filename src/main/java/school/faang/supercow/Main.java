package school.faang.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss("superCow", 5);

        List<Player> players = List.of(
                new Player("P1"),
                new Player("P2"),
                new Player("P3"),
                new Player("P4"),
                new Player("P5"),
                new Player("P6"),
                new Player("P7"),
                new Player("P8"),
                new Player("P9"),
                new Player("P10"),
                new Player("P11"),
                new Player("P12"),
                new Player("P13"),
                new Player("P14")
        );

        ExecutorService executor = Executors.newFixedThreadPool(14);
        players.forEach(player -> executor.submit(() -> player.doBattle(boss)));

        executor.shutdown();
        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
}