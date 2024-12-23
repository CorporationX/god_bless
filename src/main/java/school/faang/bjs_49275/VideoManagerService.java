package school.faang.bjs_49275;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class VideoManagerService {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TERMINATION_TIMEOUT = 10;

    public void startService() {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        IntStream.range(0, NUM_VIDEOS)
                .forEach(i -> IntStream.range(0, NUM_THREADS / NUM_VIDEOS)
                        .forEach(j -> executor.submit(() -> {
                            String videoName = "Video #%d".formatted(i);
                            videoManager.addView(videoName);
                            int viewsCount = videoManager.getViewCount(videoName);
                            log.info("ViewsCount for Video {}:{}", videoName,
                                    viewsCount);
                        })));

        executor.shutdown();

        try {
            executor.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Interrupted while waiting for termination", e);
        }
    }
}
