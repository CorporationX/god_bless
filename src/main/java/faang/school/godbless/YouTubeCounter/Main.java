package faang.school.godbless.YouTubeCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args)  {
        Map<Integer, Integer> viewsMap = new HashMap<>();
        VideoManager videoManager = new VideoManager(viewsMap);
        int NUM_THREADS = 100;
        int NUM_VIDEOS = 100;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        videoManager.addView(NUM_VIDEOS);
        int threadsPerVideo = NUM_THREADS / NUM_VIDEOS;
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < threadsPerVideo; j++) {
                int videoId = i;
                executor.execute(() -> videoManager.addView(videoId));
            }
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
