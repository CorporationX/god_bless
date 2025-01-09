package school.faang.task_49638;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {

    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            final String videoId = "Video-" + (i % NUM_VIDEOS);
            executorService.submit(() -> {
                videoManager.addView(videoId);
                System.out.println("Views for " + videoId + ": " + videoManager.getViewCount(videoId));
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final views count:");
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video-" + i;
            System.out.println(videoId + ": " + videoManager.getViewCount(videoId));
        }
    }

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
        System.out.println("Video " + videoId + " updated views: " + viewsMap.get(videoId));
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

}