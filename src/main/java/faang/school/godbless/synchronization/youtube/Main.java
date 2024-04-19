package faang.school.godbless.synchronization.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 1000;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        log.info("Uploading " + NUM_VIDEOS + " videos...");

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoManager.uploadVideo(String.valueOf(i));
        }

        log.info("Videos uploaded successfully.");

        ExecutorService watchers = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                watchers.submit(() -> videoManager.addView(videoId));
            }
        }

        watchers.shutdown();

        try {
            watchers.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("The program was interrupted from outside");
        }

        log.info("Watchers stopped.");
    }
}
