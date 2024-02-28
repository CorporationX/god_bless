package faang.school.godbless.r_edzie.synchronization.youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 100;
    private static final int TERMINATION_TIMEOUT = 5;

    private Map<String, Integer> viewsMap = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video-" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);

                    System.out.println(videoId + " " + viewCount);
                });
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MINUTES);
    }

    public synchronized void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }
}
