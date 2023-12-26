package faang.school.godbless.mutlithreading_synchronization.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {

    private static final int NUM_THREADS = 10000;
    private static final int NUM_VIDEOS = 10;
    private static final Map<String, Integer> viewsMap = new HashMap();

    public void addView(String videoId) {
        synchronized (this) {
            viewsMap.computeIfPresent(videoId, (key, val) -> val + 1);
        }
//        viewsMap.merge(videoId, 1, (oldVal, newVal) -> oldVal + newVal);
//        viewsMap.put(videoId, viewsMap.get(videoId) + 1);
    }

    public int getViewCount(String videoId) {
        synchronized (this) {
            return viewsMap.get(videoId);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            viewsMap.put(videoId, 0);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println(Thread.currentThread().getName() + " - view count - " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println(viewsMap);

    }
}
