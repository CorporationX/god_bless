package school.faang.task_61953;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 8;
    private static final int END_TIME = 21;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i < NUM_THREADS; i++) {
            StringBuilder videoId = new StringBuilder();
            videoId.append("video ").append(i);

            for (int j = 0; j < NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId.toString());
                    log.info("Видео: {}, Просмотры {}", videoId,
                            videoManager.getViewCount(videoId.toString()));
                });
            }
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(END_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                log.info("Поток завершился!");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            log.info("Принудительно прерван поток");
        }
    }
}
