package faang.school.godbless.task.multithreading.bro.force;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_POOL_LIMIT = 4;

    private static final Game game = new Game();
    private static List<Player> players;

    public static void main(String[] args) {
        players = getPlayers();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
        players.forEach(executor::execute);
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("Player 1", game),
                new Player("Player 2", game),
                new Player("Player 3", game),
                new Player("Player 4", game),
                new Player("Player 5", game),
                new Player("Player 6", game)
        );
    }
}
