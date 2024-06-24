package faang.school.godbless.synch3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_PLAYERS_ON_BOSS = 2;
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS_ON_BOSS);
        List<Player> players = getPlayers();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        players.forEach(player -> executor.execute(() -> player.startBattle(boss)));
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return List.of(new Player("Oleg"), new Player("Misha"),
                new Player("Max"), new Player("Sasha"));
    }
}
