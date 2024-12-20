package school.faang.task_49185;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.submit(() -> player.play());
        executor.submit(() -> player.skip());
        executor.submit(() -> player.previous());
        executor.submit(() -> player.pause());

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
