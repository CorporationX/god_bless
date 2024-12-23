package school.faang.task_49422;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;
    public static final int TIMEOUT = 700;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    log.info("Video {} просмотров: {}", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                log.info("Время, отведенное на завершение программы закончилось");
            }
        } catch (InterruptedException e) {
            log.error("Main поток был прерван во время ожидания завершения ", e);
            Thread.currentThread().interrupt();
        }
    }
}