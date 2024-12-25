package school.faang.sprint_3.task_49302;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    static final int NUM_THREADS = 100;
    static final int NUM_VIDEOS = 10;

    @SneakyThrows
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "VIDEO" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println(
                        "Video " + videoId + " просмотров: " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            log.info("VIEWS VIDEO {}", videoManager.getViewsMap());
        } else {
            executor.shutdownNow();
            log.info("VIDEO NOT VIEWS");
        }
    }
}
