package school.faang.multithreading.synchronize.bjs2_90108;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class App {
    private static final List<String> VIDEO_IDS = List.of("325", "266", "32345", "6332");
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = VIDEO_IDS.size();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                int idIndex = i;
                executorService.execute(() -> {
                    videoManager.addView(VIDEO_IDS.get(idIndex));

                    int count = videoManager.getViewCount(VIDEO_IDS.get(idIndex));
                    log.info("Video id {}. Thread {} added view. View counts = {}",
                            VIDEO_IDS.get(idIndex),
                            Thread.currentThread().getId(),
                            count);
                });
            }
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}