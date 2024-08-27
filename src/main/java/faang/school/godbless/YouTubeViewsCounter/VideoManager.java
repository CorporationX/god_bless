package faang.school.godbless.YouTubeViewsCounter;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 4;
    private static final int PARALLEL_VIEWS = NUM_THREADS / NUM_VIDEOS;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_VIDEOS)
                .mapToObj(String::valueOf)
                .forEach(videoId -> {
                    for (int count = 0; count < PARALLEL_VIEWS; count++) {
                        executorService.execute(() -> {
                            videoManager.addView(videoId);
                            videoManager.getViewCount(videoId);

                        });
                    }
                });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES)) {
                executorService.shutdownNow();

            }
            IntStream.range(0, NUM_VIDEOS).forEach((i) -> videoManager.getViewCount(String.valueOf(i)));
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public void addView(String videoId) {
        synchronized (viewsMap) {
            int newCount = viewsMap.getOrDefault(videoId, 0) + 1;
            viewsMap.put(videoId, newCount);
            log.info("Added view to videoId {}. Total views: {}", videoId, newCount);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            int viewCount = viewsMap.getOrDefault(videoId, 0);
            log.info("videoId {} Views {}", videoId, viewCount);
            return viewCount;
        }
    }
}
