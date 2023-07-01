package faang.school.godbless.youtube_views_counter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        HashMap<String, Integer> videos = new HashMap<>();
        VideosManager videosManager = new VideosManager(videos);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for(int i = 1; i <= NUM_VIDEOS; i++) {
            String newVideo = "video-" + i;
            videos.put(newVideo, 0);
            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                executorService.submit(() -> videosManager.addView(newVideo));
                System.out.println("Video " + newVideo + " views " + videosManager.getViewCount(newVideo) + " times!");
            }

        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(3, TimeUnit.SECONDS);
            System.out.println("Done!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
