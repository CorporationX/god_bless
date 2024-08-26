package faang.school.godbless.thirdsprint.youtubeviews;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class VideoManager {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int SECONDS_AWAIT = 30;

    private final Map<String, Integer> viewsMap = new HashMap<>();

    public synchronized void addView(String videoId) {
        viewsMap.put(videoId, viewsMap.getOrDefault(videoId, 0) + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;

            IntStream.range(0, NUM_THREADS / NUM_VIDEOS).forEach(index ->
                    executorService.execute(() -> {
                        videoManager.addView(videoId);
                        int viewCount = videoManager.getViewCount(videoId);
                        System.out.println("Видео: " + videoId + ", просмотров: " + viewCount);
                    })
            );
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(SECONDS_AWAIT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
