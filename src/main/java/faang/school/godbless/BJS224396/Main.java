package faang.school.godbless.BJS224396;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            Video video = new Video(i);
            long videoId = video.getVideoId();
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("Video ID: {} - View Count: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Не все задачи завершены вовремя!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Ожидание выполнения потоков было прервано", e);
            executor.shutdownNow();
        }
    }
}
