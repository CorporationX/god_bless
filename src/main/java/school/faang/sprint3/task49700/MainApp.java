package school.faang.sprint3.task49700;

import school.faang.sprint3.task49700.model.Boss;
import school.faang.sprint3.task49700.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int MAX_BATTLE_PLAYERS = 10;
    private static final int BATTLE_PLAYERS = 15;
    private static final int TIME_TO_KILL = 5000;
    private static final int TIME_DELTA = 500;

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        for (int i = 0; i < BATTLE_PLAYERS; i++) {
            Player player = new Player("Player " + i);
            players.add(player);
        }
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(THREAD_POOL_SIZE);

        Boss boss = new Boss(MAX_BATTLE_PLAYERS);
        for (Player player : players) {
            executor.submit(() -> player.startBattle(boss));
            try {
                Thread.sleep(TIME_DELTA);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(TIME_TO_KILL);
            boss.killEmAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(2, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
