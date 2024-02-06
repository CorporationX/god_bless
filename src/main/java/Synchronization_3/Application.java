package Synchronization_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Boss boss = new Boss(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(() -> new Player("Player" + (finalI + 1)).startBattle(boss));
        }
        executor.shutdown();
    }
}
