package school.faang.BJS2_36862_Supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            Player player = new Player("Player " + i);
            executorService.submit(() -> player.startBattle(boss));
        }

        executorService.shutdown();
        boss.shutdownService();
    }
}
