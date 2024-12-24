package school.faang.bjs_49275;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class VideoManagerService {
    private static final int NUM_THREADS = 100;
    private static final int TERMINATION_TIMEOUT = 60;

    private final VideoManager videoManager = new VideoManager();

    public void startService(List<String> videos) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        videos.forEach(video -> IntStream.range(0, NUM_THREADS / videos.size())
                .forEach(i -> executor.submit(() -> {
                    videoManager.addView(video);
                    int viewsCount = videoManager.getViewCount(video);
                    log.info("ViewsCount for Video {}:{}", video,
                            viewsCount);
                }))
        );

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for termination", e);
        }
    }

    public int getViewCount(List<String> videos) {
        return videos.stream()
                .map(videoManager::getViewCount)
                .reduce(0, Integer::sum);
    }
}
