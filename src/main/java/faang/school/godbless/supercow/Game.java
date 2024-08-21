package faang.school.godbless.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Game {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = Arrays.asList(
                new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5"),
                new Player("Player6")
        );
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        players.forEach(player -> executorService.execute(() -> player.startBattle(boss)));
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}