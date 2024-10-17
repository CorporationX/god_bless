package bjs2_35742;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int TOTAL_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_THREADS);

        Boss boss = new Boss(2, 0, new ArrayList<>());

        List<Player> players = List.of(
                new Player("John"),
                new Player("Josh"),
                new Player("Jess")
        );

        players.forEach((player) -> executorService.submit(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }));

        Thread.sleep(500);
        Player somePlayer = boss.getPlayers().get(0);
        somePlayer.leaveBattle(boss);

        executorService.shutdown();
    }
}
