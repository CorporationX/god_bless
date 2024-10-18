package school.faang.youtubecounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "Video_" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(video);
                    System.out.println("Video: " + video + " Count: " + videoManager.getViewCount(video));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Some tasks were not completed in expected time. Closing running tasks.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread execution has been unexpectedly interrupted. Closing running tasks. ");
            e.printStackTrace();
            executor.shutdownNow();
        }
        System.out.println("All threads were closed now");
    }
}