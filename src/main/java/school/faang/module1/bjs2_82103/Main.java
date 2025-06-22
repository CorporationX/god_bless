package school.faang.module1.bjs2_82103;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int POOL_SIZE = 5;
    private static final int MAX_PLAYERS = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);
        executorService.execute(() -> new Player("player1").doBattle(boss));
        executorService.execute(() -> new Player("player2").doBattle(boss));
        executorService.execute(() -> new Player("player3").doBattle(boss));
        executorService.execute(() -> new Player("player4").doBattle(boss));
        executorService.execute(() -> new Player("player5").doBattle(boss));
        executorService.shutdown();
    }
}