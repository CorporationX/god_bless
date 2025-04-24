package school.faang.stream3.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final long MAX_WAIT_MINUTES = 1;

    public static void main(String[] args) {
        Game game = new Game(0, 0);
        List<Player> playerList = List.of(
                new Player("Player0", game, 10, 0),
                new Player("Player1", game, 11, 0),
                new Player("Player2", game, 9, 0),
                new Player("Player3", game, 7, 3),
                new Player("Player4", game, 10, 0)
        );

        ExecutorService poolExecutor = Executors.newFixedThreadPool(playerList.size());

        playerList
                .forEach(player -> poolExecutor.execute(() -> {
                    do {
                        player.playCycle();
                    } while (player.getLives() > 0);
                    log.info("{} loose all of his lives", player.getName());
                }));

        poolExecutor.shutdown();
        try {
            if (!poolExecutor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                log.info("Завершаем принудительно после {}", MAX_WAIT_MINUTES);
                poolExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание завершения потоков прервано.");
            poolExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Main завершил работу");

    }
}
