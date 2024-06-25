package faang.school.godbless.sync.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService threadPool = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                threadPool.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video ID: " + videoId + ", View count: " + videoManager.getViewCount(videoId));
                });
            }
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
