package school.faang.bjs_49692;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class BattleService {
    private static final int BOSS_MAX_PLAYERS = 5;
    private static final int PLAYERS_COUNT = 20;
    private static final int THREAD_POOL_SIZE = 10;
    private static final int TERMINATION_TIMEOUT_SECONDS = 60;

    public void battle() {
        Boss boss = new Boss(BOSS_MAX_PLAYERS);
        List<Player> players = IntStream.range(0, PLAYERS_COUNT)
                .boxed()
                .map(i -> new Player("Player %d".formatted(i)))
                .toList();

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        players.forEach(player -> executorService.submit(() -> player.startBattle(boss)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Battle thread interrupted", e);
        }
    }
}
