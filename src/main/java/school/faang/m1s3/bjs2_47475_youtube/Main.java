package school.faang.m1s3.bjs2_47475_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video_" + (i + 1);
            videoManager.getViewsMap().put(videoId, 0);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Thread #" +Thread.currentThread().getName() +
                            "\t video id: " + videoId +
                            "; number of views: " + videoManager.getViewCount(videoId));
                });
            }
        }

        service.shutdown();

        try {
            if(!service.awaitTermination(5, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Thread has been interrupted " + e.getMessage(), e);
        }
    }
}
