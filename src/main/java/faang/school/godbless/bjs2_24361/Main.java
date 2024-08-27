package faang.school.godbless.bjs2_24361;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int BOSS_MAX_PLAYERS = 2;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        Boss boss = new Boss(BOSS_MAX_PLAYERS);

        List<Player> players = List.of(
                new Player("p1"),
                new Player("p2"),
                new Player("p3"),
                new Player("p4"),
                new Player("p5")
        );

        players.forEach(p -> executorService.submit(() -> p.startBattle(boss)));

        executorService.shutdown();
    }
}
