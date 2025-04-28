package school.faang.bjs2_73485;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int MAX_PLAYERS = 5;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);

        List<Player> players = new ArrayList<>(List.of(
                new Player("1"),
                new Player("2"),
                new Player("3"),
                new Player("4"),
                new Player("5"),
                new Player("6"),
                new Player("7"),
                new Player("8"),
                new Player("9"),
                new Player("10")
        ));

        ExecutorService executor = Executors.newCachedThreadPool();

        for (Player player : players) {
            executor.execute(() -> player.doBattle(boss));
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                log.info("Задачи не завершились за {} минут, принудительно останавливаем...", TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
