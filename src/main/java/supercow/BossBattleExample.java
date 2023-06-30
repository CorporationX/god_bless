package supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BossBattleExample {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        int playerAmount = 5;
        for (int i = 1; i <= playerAmount; i++) {
            Player player = new Player("Player " + i);
            executorService.submit(() -> player.startBattle(boss));
        }

        executorService.shutdown();

        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println("All fights finished");
    }
}
