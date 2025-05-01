package school.faang.multithreading.synchronization.bjs2_73827.youtube_counter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        IntStream.range(0, NUM_VIDEOS).forEach(i ->
                IntStream.range(0, NUM_THREADS).forEach(j -> {
                    String videoName = String.format("Video number %d", i);
                    executorService.submit(() -> {
                        videoManager.addView(videoName);
                        log.info("{} has {} views", videoName, videoManager.getViewCount(videoName));
                    });
                }));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Force Termination.");
                executorService.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            executorService.shutdownNow();
        }

        videoManager.printViews();
    }
}

