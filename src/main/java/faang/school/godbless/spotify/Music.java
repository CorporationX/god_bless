package faang.school.godbless.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private final static int NUMS_THREAD = 4;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newScheduledThreadPool(NUMS_THREAD);
        executor.submit(() -> new Player().play());
        executor.submit(() -> new Player().pause());
        executor.submit(() -> new Player().skip());
        executor.submit(() -> new Player().previous());
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.MINUTES);
    }
}
