package school.faang.sync.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 100;
    private static final int TERMINATION_MN = 1;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService viewers = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = String.format("Video %d", ThreadLocalRandom.current().nextInt(1, 4));
            for (int j = 0; j < NUM_THREADS; j++) {
                viewers.submit(() -> {
                    videoManager.addView(video);
                    log.info("{} current view count is {}", video, videoManager.getViewCount(video));
                });
            }
        }

        viewers.shutdown();
        try {
            if (!viewers.awaitTermination(TERMINATION_MN, TimeUnit.MINUTES)) {
                viewers.shutdownNow();
            }
        } catch (InterruptedException e) {
            viewers.shutdownNow();
        }
    }
}
