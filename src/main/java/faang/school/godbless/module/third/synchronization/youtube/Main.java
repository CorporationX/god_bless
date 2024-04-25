package faang.school.godbless.module.third.synchronization.youtube;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 3;
    
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.addVideo(String.valueOf(i));
        }
        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.execute(() -> {
                String videoId = String.valueOf(new Random().nextInt(NUM_VIDEOS));
                for (int j = 0; j < 5; j++) {
                    videoManager.addView(videoId);
                    log.info(
                        "Thread {} decided to see video \"{}\" view count - {}",
                        Thread.currentThread().getName(),
                        videoId,
                        videoManager.getViewCount(videoId)
                    );
                }
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

