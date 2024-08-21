package faang.school.godbless.thirdsprint.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = List.of(
                new Player("Игрок 1"),
                new Player("Игрок 2"),
                new Player("Игрок 3"),
                new Player("Игрок 4"),
                new Player("Игрок 5"),
                new Player("Игрок 6"),
                new Player("Игрок 7")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(players.size());
        players.forEach(player -> executorService.execute(() -> player.startBattle(boss)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
