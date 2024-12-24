package school.faang.sprint3.bjs_49610;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        int maxPlayers = 3;
        int players = 5;
        int timeOut = 1;
        int timeForGame = 2000;

        List<Player> playerList = new ArrayList<>();
        for (int i = 0; i < players; i++) {
            playerList.add(new Player("Name" + i ));
        }

        Boss boss = new Boss(maxPlayers);

        ExecutorService executorService = Executors.newFixedThreadPool(players);
        playerList.forEach(player -> executorService.execute(() -> {
            try {
                player.startGame(boss);
                Thread.sleep(timeForGame);
                player.finishGame(boss);
            } catch (InterruptedException e) {
                log.error("Unexpected error");
            }
        }));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(timeOut, TimeUnit.MINUTES)) {
                log.warn("Not all threads stopped by themselves");
            }
        } catch (InterruptedException e) {
            log.error("Threads forced to stopped");
        } finally {
            executorService.shutdownNow();
        }
    }
}
