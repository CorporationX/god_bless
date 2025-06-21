package school.faang.sprint3.bjs2_81715;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 100;

    public synchronized int addView(String videoId) {
        return viewsMap.compute(videoId, (id, count) -> count == null ? 1 : count + 1);
    }

    public synchronized Integer getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            int videoIndex = i;
            executor.execute(() -> manager.addView(String.valueOf(videoIndex)));
        }
        for (int i = 0; i < NUM_VIDEOS; i++) {
            int videoIndex = i;
            executor.execute(() -> {
                String videoId = String.valueOf(videoIndex);
                System.out.printf("Id: %s, views: %s\n", videoId, manager.getViewCount(videoId));
            });
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
