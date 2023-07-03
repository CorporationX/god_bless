package faang.school.godbless.youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new HashMap<>();

    public void addView(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                viewsMap.put(videoId, 1);
                return;
            }
            int res = viewsMap.get(videoId);
            viewsMap.put(videoId, res + 1);
        }
    }

    public int getViewCount(String videoId) {
        synchronized (viewsMap) {
            if (!viewsMap.containsKey(videoId)) {
                return 0;
            }
            return viewsMap.get(videoId);
        }
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        final int res = NUM_THREADS / NUM_VIDEOS;

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId1 = "video" + i;
            for (int j = 0; j < res; j++) {
                executorService.submit(() -> videoManager.addView(videoId1));
            }
            System.out.println("Количество просмотров у " + videoId1 + ": " + videoManager.getViewCount(videoId1));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
