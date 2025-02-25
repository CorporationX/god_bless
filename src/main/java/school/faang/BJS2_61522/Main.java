package school.faang.BJS2_61522;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PLAYERS_COUNT = 4;
    private static final int THREAD_COUNT = 4;
    private static final int MAX_BOSS_PLAYERS = 2;

    public static void main(String[] args) {
        Set<Player> players = new HashSet<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Boss boss = new Boss(MAX_BOSS_PLAYERS);
        for (int i = 0; i < PLAYERS_COUNT; i++) {
            players.add(new Player("player_" + i));
        }
        players.forEach(player -> executorService.submit(() -> player.doBattle(boss)));
        executorService.shutdown();
    }
}
