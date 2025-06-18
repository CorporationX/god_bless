package school.faang.bjs2_81690;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    private static VideoManager manager = new VideoManager();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + ThreadLocalRandom.current().nextInt(NUM_VIDEOS);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> manager.addView(videoId));
                log.info("У видео '{}' просмотров {}", videoId, manager.getViewCount(videoId));
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
        }
        log.info("Все задачи завершены");
    }
}
