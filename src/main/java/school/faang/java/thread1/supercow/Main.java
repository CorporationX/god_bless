package school.faang.java.thread1.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(11);
        Boss boss = new Boss();
        for (int i = 0; i < 10; i++) {
            Player player = new Player("Player " + i);
            Runnable runnable = () -> player.startBattle(boss);
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
