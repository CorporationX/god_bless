package faang.school.godbless.multithreading_synchronization.task_3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SuperCow {

    private static final int THREAD_COUNT = 4;
    private static final int MAX_PLAYERS = 2;

    public static void main(String[] args) {
        final List<Player> players = getPlayers();
        final Boss boss = new Boss(MAX_PLAYERS);
        final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        players.forEach(player -> executor.submit(() -> player.startBattle(boss)));
        executor.shutdown();
    }

    private static List<Player> getPlayers() {
        return List.of(
                new Player("Kostya"),
                new Player("David"),
                new Player("Alex"),
                new Player("Dima")
        );
    }
}
