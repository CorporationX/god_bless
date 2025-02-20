package bjs261587;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 6;
    private static final int NUM_VIDEOS = 9;
    private static final int TASKS_COMPLETED_DURATION_MS = 2000;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Map<String, Long> viewsMap = new HashMap<>();
        VideoManager videoManager = new VideoManager(viewsMap);
        List<String> videos = List.of("Video1", "Video2", "Video3", "Video4",
                "Video5", "Video6", "Video7", "Video8", "Video9");
        if (videos.size() > NUM_VIDEOS) {
            throw new IllegalStateException("The number of videos is larger than the allowed size");
        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String videoId = videos.get(i);
                executorService.submit(() -> videoManager.addView(videoId), videoId);
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TASKS_COMPLETED_DURATION_MS, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            LOGGER.error("Waiting for the completion of tasks in the ExecutorService is interrupted in the thread {}",
                    Thread.currentThread().getName());
            executorService.shutdownNow();
        }
    }
}
