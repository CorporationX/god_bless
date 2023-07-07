package faang.school.godbless.thirdSprint.YouTube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            int videoId = i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.execute(() -> {
                    manager.addView(videoId);
                    int viewCount = manager.getViewCount(videoId);
                    System.out.println("Video " + videoId + " has " + viewCount + " views");
                });
            }
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All views have been counted");
    }
}
