package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int PLAYERS_COUNT = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(1);
        ExecutorService executor = Executors.newFixedThreadPool(PLAYERS_COUNT);

        List<Player> players = List.of(new Player("Mage"), new Player("Warrior"));
        players.forEach(player -> executor.execute(() -> player.doBattle(boss)));

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
