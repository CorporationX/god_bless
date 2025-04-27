package school.faang.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Music {
    private static int THREAD_POOL = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);
        Player player = new Player();

        executorService.submit(player::play);
        executorService.submit(player::pause);
        executorService.submit(player::skip);
        executorService.submit(player::previous);

        executorService.shutdown();
    }
}
