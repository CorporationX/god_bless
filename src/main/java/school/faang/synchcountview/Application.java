package school.faang.synchcountview;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Application {
    private final static int NUM_THREADS = 100;
    private final static int NUM_VIDEOS = 10;
    private final static int TIMEOUT_SEC = 2;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String id = "video " + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(id);
                    log.info("Thread: {}, Video {}, count views: {}", Thread.currentThread().getName(), id, videoManager.getViewCount(id));
                });
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(TIMEOUT_SEC, TimeUnit.SECONDS)) {
                log.info("It's OK");
            } else {
                executorService.shutdownNow();
                log.info("executorService.shutdownNow() ran");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
