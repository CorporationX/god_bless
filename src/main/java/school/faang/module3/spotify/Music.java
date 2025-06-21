package school.faang.module3.spotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int USER_COUNT = 150;

    private static final int PLAYER_METHOD_COUNT = 4;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Player player = new Player();
        for (int i = 0; i < USER_COUNT; i++) {
            Runnable runnable = switch (i % PLAYER_METHOD_COUNT) {
                case 0 -> player::play;
                case 1 -> player::pause;
                case 2 -> player::skip;
                case 3 -> player::previous;
                default -> throw new IllegalStateException("player method count not equal with PLAYER_METHOD_COUNT");
            };
            executor.execute(runnable);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("not all threads terminated. start force termination...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executor.shutdownNow();
        }
    }
}
