package faang.school.godbless.task.multithreading.bro.force;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_PLAYERS = 6;
    private static final int THREAD_POOL_LIMIT = NUMBER_OF_PLAYERS;

    private static final Game game = new Game();
    private static List<Player> players = getPlayers();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_LIMIT);
        players.forEach(executor::execute);
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_PLAYERS)
                .mapToObj(i -> new Player("Player " + i, game))
                .toList();
    }
}
