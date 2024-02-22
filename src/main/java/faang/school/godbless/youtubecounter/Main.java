package faang.school.godbless.youtubecounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Long.MAX_VALUE;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 2;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video number " + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    videoManager.getViewCount(videoId);
                });
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(MAX_VALUE, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
