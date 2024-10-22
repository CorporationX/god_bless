package school.faang_sprint_3.blocking_spotify;

import java.util.concurrent.Executors;

public class Music {
    public static final int THREAD_POOL_SIZE = 4;

    public static void main(String[] args) {
        var player = new Player();

        var threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        threadPool.submit(player::play);
        threadPool.submit(player::pause);
        threadPool.submit(player::skip);
        threadPool.submit(player::previous);
        threadPool.shutdown();
    }
}
