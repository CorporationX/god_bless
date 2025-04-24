package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 10000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        ExecutorService resultPool = Executors.newSingleThreadExecutor();
        VideoManager videoManager = new VideoManager();
        List<String> videos = IntStream.range(1, NUM_VIDEOS + 1).boxed().map(String::valueOf).toList();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            final String videoId = videos.get(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> videoManager.addView(videoId));
                Future<Integer> viewsFuture = executor.submit(() -> videoManager.getViewCount(videoId));

                resultPool.execute(() -> {
                    try {
                        Integer count = viewsFuture.get();
                        log.info("Thread {}: Views for video {} - {}", Thread.currentThread().getName(), videoId, count);
                    } catch (Exception e) {
                        log.error("Exception was thrown", e);
                    }
                });
            }
        }

        executor.shutdown();
        resultPool.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            } else if (!resultPool.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                resultPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted", e);
            executor.shutdownNow();
            resultPool.shutdownNow();
        }
        System.out.println("Main thread done");
    }
}
