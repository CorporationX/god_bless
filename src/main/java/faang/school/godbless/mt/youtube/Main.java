package faang.school.godbless.mt.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 60;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videos = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add(String.format("video_%s", i));
        }

        for (var video : videos) {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    log.info("Video {} views {}", video, videoManager.getViewCount(video));
                });
            }
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            log.warn("Thread is interrupted");
        }

    }
}
