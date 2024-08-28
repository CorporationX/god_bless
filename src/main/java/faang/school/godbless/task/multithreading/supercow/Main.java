package faang.school.godbless.task.multithreading.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int NUMBER_OF_PLAYERS = 10;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_PLAYERS;
    private static final int LOBBY_SIZE = 4;

    private static final ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    private static final Boss boss = new Boss(LOBBY_SIZE);
    private static List<Player> players = getPlayers();

    public static void main(String[] args) {
        runTask();
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_PLAYERS)
                .mapToObj(i -> new Player("Player " + i))
                .toList();
    }

    private static void runTask() {
        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
    }
}
