package school.faang.task_61678;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static final int MAX_PLAYERS = 2;
    public static final int MAX_THREADS = 5;
    public static final int BATTLE_EXECUTOR_TIMEOUT = 5;

    public static void main(String[] args) {
        final var battleExecutor = Executors.newFixedThreadPool(MAX_THREADS);
        final var boss = new Boss(MAX_PLAYERS);
        final var players = getPlayers();

        submitPlayersToBattle(battleExecutor, players, boss);

        shutdownExecutorGracefully(battleExecutor);
    }

    private static void shutdownExecutorGracefully(ExecutorService battleExecutor) {
        battleExecutor.shutdown();

        try {
            if (!battleExecutor.awaitTermination(BATTLE_EXECUTOR_TIMEOUT, TimeUnit.SECONDS)) {
                battleExecutor.shutdownNow();
                log.warn("Battle executor did not terminate within the timeout.");
            }
        } catch (InterruptedException e) {
            battleExecutor.shutdownNow();
            log.error("Battle executor interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    private static void submitPlayersToBattle(ExecutorService battleExecutor, List<Player> players, Boss boss) {
        players.forEach(player -> battleExecutor.submit(() -> player.doBattle(boss)));
    }

    private static List<Player> getPlayers() {
        return Stream.of(
                "Alice",
                "Bob",
                "Charlie",
                "David",
                "Eve",
                "Frank",
                "Grace",
                "Hank",
                "Ivy",
                "Jack").map(Player::new).toList();
    }
}
