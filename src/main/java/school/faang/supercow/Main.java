package school.faang.supercow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2);
        List<Player> players = List.of(
                new Player("Simon"),
                new Player("Dimon"),
                new Player("Limon"),
                new Player("Bimon")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(players.size());

        for (Player player : players) {
            executorService.submit(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });
        }
        executorService.shutdown();
    }
}
