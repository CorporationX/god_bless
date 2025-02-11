package school.faang.bjs249480;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        List<UUID> videIds = Stream.generate(UUID::randomUUID)
                .limit(NUM_VIDEOS)
                .toList();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        videIds.forEach(id -> {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.execute(() -> {
                    videoManager.addView(id);
                    log.info("Video id = {}, views = {}", id, videoManager.getViewCount(id));
                });
            }
        });
        shutdown(executorService);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(Main.TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
