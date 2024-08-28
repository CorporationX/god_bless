package faang.school.godbless.thirdsprint.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_PLAYERS = 10;
    private static final int NUM_SLOTS = 4;

    public static void main(String[] args) {
        Boss boss = new Boss(NUM_SLOTS);
        List<Player> players = getPlayers();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_PLAYERS);
        players.forEach(player -> executorService.execute(() -> player.startBattle(boss)));
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }

    public static List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        IntStream.range(1, NUM_PLAYERS + 1)
                .forEach(index -> players.add(new Player("Игрок " + index)));
        return players;
    }
}
