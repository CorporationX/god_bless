package faang.school.godbless.synchronization.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    private static final int DEFAULT_PLAYERS_NUMBER = 5;

    public static void main(String[] args) {
        Boss boss1 = new Boss("Boss 1", 3);
        List<Player> players = generatePlayers(DEFAULT_PLAYERS_NUMBER);

        ExecutorService executorService = Executors.newCachedThreadPool();

        players.forEach(player -> executorService.execute(() -> player.startBattle(boss1)));

        executorService.shutdown();

    }

    private static List<Player> generatePlayers(int playersNum) {
        return IntStream.rangeClosed(1, playersNum)
                .boxed()
                .map(i -> new Player("Player " + i))
                .toList();
    }
}
