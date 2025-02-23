package school.faang.youtubeviewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 50;
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                EXECUTOR.submit(() -> videoManager.addView(videoId));
                log.info("Видео {} набрало {} просмотров!", videoId, videoManager.getViewCount(videoId));
            }
        }

        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(10, TimeUnit.SECONDS)) {
                EXECUTOR.shutdown();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }
}