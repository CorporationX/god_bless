package school.faang.supercow.main;

import school.faang.supercow.maincode.Boss;
import school.faang.supercow.maincode.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(2, 0);

        Player firstPlayer = new Player("Gadzhi");
        Player secondPlayer = new Player("Dima");
        Player thirdPlayer = new Player("Vlad");

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        executor.submit(() -> firstPlayer.startBattle(boss));
        executor.submit(() -> secondPlayer.startBattle(boss));
        executor.submit(() -> thirdPlayer.startBattle(boss));

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
