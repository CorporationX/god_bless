package school.faang.sprint3.multithreading.task61990;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 4;
    public static final int NUM_VIDEOS = 8;
    public static final int NUM_VIEWS = 200;
    public static final int TIMEOUT = 2;

    public static void main(String[] args) {
        Map<String, Integer> videos = new HashMap<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videos.put("id100" + i, 0);
        }
        VideoManager videoManager = new VideoManager(videos);
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (Map.Entry<String, Integer> entry : videos.entrySet()) {
            executorService.execute(() -> {
                for (int j = 0; j < NUM_VIEWS; j++) {
                    videoManager.addView(entry.getKey());
                    System.out.printf("\nVideo %s has views: %d", entry.getKey(),
                            videoManager.getViewCount(entry.getKey()));
                }
            });
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(2, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("\nAll videos, all views: " + videoManager.getViewsMap());
    }
}
