package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BossFightingTesting {
    public static void main(String[] args) {
        Boss boss = new Boss();

        ExecutorService executor = Executors.newFixedThreadPool(7);

        for (int i = 0; i < 7; i++) {
            Player player = new Player("Игрок" + i);
            executor.submit(() -> player.doBattle(boss));
        }


    }
}
