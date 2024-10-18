package youtube_view_counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    /**
     * Increments the view count for a video.
     *
     * <p>This is a thread-safe operation.
     *
     * @param videoId the ID of the video
     */
    public void addView(String videoId) {
        viewsMap.merge(videoId, 1, Integer::sum);
    }

    /**
     * Gets the current view count for a video.
     *
     * @param videoId the ID of the video
     * @return the current view count of the video, or 0 if the video ID is not
     *     recognized
     */
    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    /**
     * Simulates a scenario where multiple threads are concurrently
     * incrementing the view counts of multiple videos.
     *
     * @param args ignored
     * @throws InterruptedException if the main thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        int NUM_THREADS = 100;
        int NUM_VIDEOS = 10;
        int TIMEOUT = 1;
        List<String> videos = new ArrayList<>();
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Видео %s: %d просмотров%n", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        if (executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
            System.out.println("All threads finished");
        } else {
            executorService.shutdownNow();
        }

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            System.out.printf("Итоговые просмотры видео %s: %d%n", videoId, videoManager.getViewCount(videoId));
        }
    }
}
