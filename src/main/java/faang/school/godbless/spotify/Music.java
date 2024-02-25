package faang.school.godbless.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {

    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        executor.execute(player::play);
        executor.execute(player::pause);
        executor.execute(player::skip);
        executor.execute(player::previous);
        executor.shutdown();
        executor.awaitTermination(5L, TimeUnit.MINUTES);
    }
}
