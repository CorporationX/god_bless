package school.faang.youtubeviewcounter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 3;
    private static final int NUM_VIDEOS = 15;
    public static final List<String> videosId = new ArrayList<>();

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Random rnd = new Random();
        videoManager.addListener((v, c) ->
                log.info("▶ LIVE: Video {} → views {}", v, c)
        );

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video-" + rnd.nextInt(100, 1000) + ".mp4";
            videosId.add(videoId);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> videoManager.addView(videoId));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Shutting down thread after 5 seconds");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread was interrupted while waiting.", e);
        }
        videosId.forEach(v -> System.out.printf("Video %s views: %d\n", v, videoManager.getViewCount(v)));
    }
}
