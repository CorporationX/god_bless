package youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 25;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video-" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                service.submit(() -> {
                    manager.addView(videoId);
                    System.out.println("View count for video " + videoId + ": " + manager.getViewCount(videoId));
                });
            }
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(1, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }
    }
}
