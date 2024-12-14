package school.faang.YouTube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_VIDEOS = 100;
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_VIDEOS/NUM_THREADS; j++) {
                service.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video ID: " + videoId +
                            ", View Count: " + videoManager.getView(videoId));
                });
            }
        }
        service.shutdown();

        try {
            if (!service.awaitTermination(10, TimeUnit.SECONDS)){
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException("Something went wrong", e);
        }

    }
}
