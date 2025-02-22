package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> new Player().play());
        executor.execute(() -> new Player().pause());
        executor.execute(() -> new Player().skip());
        executor.execute(() -> new Player().previous());
        executor.shutdown();
    }
}
