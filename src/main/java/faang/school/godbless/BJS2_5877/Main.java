package faang.school.godbless.BJS2_5877;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            videoManager.addNewVideo(videoId);
        }

        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        for (int k = 0; k < 30; k++) {
            for (int i = 0; i < NUM_VIDEOS; i++) {
                String videoId = "video" + i;
                pool.submit(() -> videoManager.addView(videoId));
            }
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            pool.submit(() -> videoManager.getViewCount(videoId));
        }

        pool.shutdown();

        try {
            if (!pool.awaitTermination(5, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.getStackTrace();
        }

    }
}
