package school.faang.Multithreading.sprint_3.YouTube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video:" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("у видео " + videoId + "  " + videoManager.getViewCount(videoId) + " просмотров\t"
                            + Thread.currentThread().getName());
                });
            }
        }

        executor.shutdown();
    }
}

