package school.faang.task_49238;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int TWO_SECONDS = 2000;
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    @SneakyThrows
    public static void main(String[] args) {
        var videoManager = new VideoManager();
        var executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video №" + (i + 1);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    int viewCount = videoManager.getViewCount(videoId);
                    log.info("By video {} views = {}", videoId, viewCount);
                });
            }
        }

        executorService.shutdown();
        while (!executorService.isShutdown()) {
            Thread.sleep(TWO_SECONDS);
        }
    }
}
