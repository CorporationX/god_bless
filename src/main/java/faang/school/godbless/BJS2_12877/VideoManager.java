package faang.school.godbless.BJS2_12877;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        if (viewsMap.containsKey(videoId)) {
            int views = viewsMap.get(videoId);
            viewsMap.put(videoId, ++views);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, -1);
    }

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("+1 view at " + videoId + ". Total views: " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("All done!");
        }
    }
}
