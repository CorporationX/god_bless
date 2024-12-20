package school.faang.spotify_lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Player player = new Player();

        executor.submit(player::play);
        executor.submit(player::skip);
        executor.submit(player::pause);
        executor.submit(player::previous);
        executor.shutdown();
        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("mission complete");
        } else {
            System.out.println("mission not complete");
        }
    }
}
