package school.faang.task_49173;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager(new ConcurrentHashMap<>());
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        String[] videos = new String[NUM_VIDEOS];
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos[i] = "video-" + i;
        }

        int bufferSize = NUM_THREADS / NUM_VIDEOS;
        for (String videoId : videos) {
            for (int i = 0; i < bufferSize; i++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    videoManager.getViewCount(videoId);
                });
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
    }
}
