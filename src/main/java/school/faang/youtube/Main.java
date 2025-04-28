package school.faang.youtube;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 10000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();
        List<String> videos = IntStream.range(1, NUM_VIDEOS + 1).boxed().map(String::valueOf).toList();
        Map<String, Future<Integer>> futures = new HashMap<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            final String videoId = videos.get(i);
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> videoManager.addView(videoId));
                futures.put(videoId, executor.submit(() -> videoManager.getViewCount(videoId)));
            }
        }

        for (Map.Entry<String, Future<Integer>> entry : futures.entrySet()) {
            while (!entry.getValue().isDone()) {
                //doing something else
            }
            try {
                log.info("Views count for video {} is {}", entry.getKey(), entry.getValue().get());
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage(), e);
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Main thread interrupted", e);
            executor.shutdownNow();
        }
        System.out.println("Main thread done");
    }
}
