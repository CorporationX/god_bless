package school.faang.m1.thread.youtube;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 100;

    Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        try {
            for (int i = 0; i < NUM_VIDEOS; i++) {
                final String videoId = "video-" + i;
                for (int j = 0; j < NUM_THREADS; j++) {
                    pool.submit(() -> videoManager.addView(videoId));
                }
            }
        } finally {
            pool.shutdown();
        }

        boolean finished = pool.awaitTermination(30, TimeUnit.SECONDS);
        if (!finished) {
            pool.shutdownNow();
            if (!pool.awaitTermination(10, TimeUnit.SECONDS)) {
                throw new RuntimeException("Pool did not terminate");
            }
        }

        for (int v = 0; v < NUM_VIDEOS; v++) {
            String videoId = "video-" + v;
            int count = videoManager.getViewCount(videoId);
            System.out.println(videoId + " -> " + count + " (expected " + NUM_THREADS + ")");
        }
    }
}
