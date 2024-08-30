package faang.school.godbless.Youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 20;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<String> videoIds = IntStream.range(0, NUM_VIDEOS)
                .mapToObj(i -> "https://www.youtube.com/watch?v=" + i)
                .toList();

        int totalTasks = Math.max(NUM_VIDEOS, NUM_THREADS);

        IntStream.range(0, totalTasks).forEach(i -> {
            String videoId = videoIds.get(i % NUM_VIDEOS);
            executorService.submit(() -> {
                videoManager.addView(videoId);
                log.info("{}: {} views", videoId, videoManager.getViewCount(videoId));
            });
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
    }
}
