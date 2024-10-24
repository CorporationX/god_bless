package supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Boss wyvern = new Boss(3);

        for (int i = 0; i < 20; i++) {
            int time = 1_000 * i;
            executorService.submit(() -> {
                try {
                    new Player("Player").startBattle(wyvern,time);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
        }

        executorService.shutdown();
    }
}
