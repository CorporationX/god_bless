package school.faang.task_49215;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = UUID.randomUUID().toString();

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    log.info("Видео: {}. Просмотров: {}",
                            videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.MINUTES)) {
                log.info("Просмотры завершены");
            } else {
                executor.shutdownNow();
                log.info("Просмотры не завершены");
            }
        } catch (InterruptedException e) {
            log.error("Ошибка завершения потоков");
        }
    }
}
