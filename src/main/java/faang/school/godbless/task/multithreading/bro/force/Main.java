package faang.school.godbless.task.multithreading.bro.force;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_POOL_LIMIT = 4;

    public static void main(String[] args) {
        var game = new Game();
        var players = List.of(
                new Player("Player 1", game),
                new Player("Player 2", game),
                new Player("Player 3", game),
                new Player("Player 4", game),
                new Player("Player 5", game),
                new Player("Player 6", game)
        );
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
        players.forEach(player -> executor.submit(player));
        executor.shutdown();
    }
}
