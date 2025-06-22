package school.faang.module3.supercow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Supercow {
    private static final String[] NAMES = {
            "James",
            "Emma",
            "Michael",
            "Olivia",
            "William",
            "Ava",
            "Benjamin",
            "Sophia",
            "Lucas",
            "Isabella"
    };

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Boss boss = new Boss(4);
        for (int i = 0; i < NAMES.length; i++) {
            var player = new Player(NAMES[i]);
            executor.execute(() -> player.doBattle(boss));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                System.out.println("not all players finished fight with the boss until timeout." +
                        " Game over, stop battle");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
