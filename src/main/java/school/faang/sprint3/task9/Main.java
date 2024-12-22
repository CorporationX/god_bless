package school.faang.sprint3.task9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {


        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            int views = i;
            executor.execute(() -> {
                for (int j = 0; j < 100; j++) {
                    manager.addView("video_" + views);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            System.out.println("video_" + i + " views: " + manager.getViewCount("video_" + i));
        }
    }
}
