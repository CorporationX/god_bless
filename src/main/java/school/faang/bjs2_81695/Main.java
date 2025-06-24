package school.faang.bjs2_81695;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 50;
    private static final int NUM_VIDEOS = 3;
    private static final int MAX_MINUTES = 1;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "видео " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    log.info("видосик: {}, количество просмотров: {}", videoId, manager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(MAX_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("произошла жесть! завершаем потоки принудительно максимально незамедлительно!");
            executor.shutdownNow();
        }
    }
}
