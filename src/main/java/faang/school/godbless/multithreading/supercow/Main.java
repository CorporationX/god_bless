package faang.school.godbless.multithreading.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(1000, 1);
        Player player1 = new Player("Джейсон Броди");
        Player player2 = new Player("Грант Броди");

        startBattle(boss, new ArrayList<>(List.of(player1, player2)));

    }

    public static void startBattle(Boss boss, List<Player> players) {
        ExecutorService executorService  = Executors.newFixedThreadPool(NUM_THREAD);

        for (Player player : players) {
            executorService.execute(() -> player.startBattle(boss));
        }

        executorService.execute(boss::deJoinBattle);
        executorService.shutdown();
    }
}
