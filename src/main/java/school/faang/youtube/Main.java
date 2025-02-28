package school.faang.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.IntStream;


public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 5;
    private static final int VIEWS_PER_THREAD = 100;
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.range(0, NUM_VIDEOS).forEach(videoIndex -> {
            String videoId = "video" + videoIndex;
            IntStream.range(0, NUM_THREADS).forEach(threadIndex -> executorService.submit(() -> {
                IntStream.range(0, VIEWS_PER_THREAD).forEach(i -> videoManager.addView(videoId));
            }));
        });

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.severe("ExecutorService was interrupted: " + e.getMessage());
            executorService.shutdownNow();
        }

        IntStream.range(0, NUM_VIDEOS).forEach(i -> {
            String videoId = "video" + i;
            logger.info(videoId + " views: " + videoManager.getViewCount(videoId));
        });
    }
}
