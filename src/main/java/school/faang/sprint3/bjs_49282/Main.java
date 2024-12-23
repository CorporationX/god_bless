package school.faang.sprint3.bjs_49282;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TERMINATION_DELAY = 300;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Количество просмотров на {}: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(TERMINATION_DELAY, TimeUnit.SECONDS);
    }
}
