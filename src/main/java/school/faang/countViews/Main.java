package school.faang.countViews;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final Random random = new Random();
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 2000;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "https://youtube.com/video/" + i;
            executor.submit(() -> {
                for (int j = 0; j < random.nextInt(10); j++) { manager.addView(videoId); }
                System.out.println(videoId + " has views: " + manager.getViewCount(videoId));
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.out.println("Some threads couldn't end their tasks.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
