package faang.school.godbless.multithreading_synchronization.youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;
    private static final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.compute(videoId, (k, v) -> (v == null) ? 0 : v + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public void addVideo(String videoId) {
        viewsMap.putIfAbsent(videoId, 0);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            videoManager.addVideo(videoId);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println(videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("Final results:");
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            System.out.println("Video " + i + " views: " + videoManager.getViewCount(String.valueOf(i)));
        }
    }
}
