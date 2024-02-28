package YoutubeCaunter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> videoMap = new HashMap<>();
    private static final Object lock = new Object();
    private static final int NUM_THREADS = 0;
    private static final int NUM_VIDEO = 0;

    void addView(String videoId) {
        synchronized (lock) {
            videoMap.put(videoId, videoMap.getOrDefault(videoId, 0) + 1);
        }
    }

    int getViewCount(String videoId) {
        synchronized (lock) {
            return videoMap.getOrDefault(videoId, 0);
        }
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEO; i++) {
            String videoId = "video# " + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEO; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);
                    System.out.println("The video " + videoId + " has " + viewCount + "views");
                });
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
