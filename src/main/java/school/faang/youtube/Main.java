package school.faang.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> manager.addView(videoId));
            }
        }

        executor.shutdown();

        if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            int views = manager.getViewCount(videoId);
            System.out.printf("%s: %d просмотров%n", videoId, views);
        }
    }
}
