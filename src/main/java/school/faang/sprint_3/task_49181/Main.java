package school.faang.sprint_3.task_49181;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_DELAY = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager(new HashMap<>());

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = String.valueOf(i);
            executorService.submit(() -> {
                for (int j = 1; j <= NUM_THREADS / NUM_VIDEOS; j++) {
                    videoManager.addView(videoId);
                }
                System.out.println(videoId + " has " + videoManager.getViewCount(videoId) + " views");
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
        }
    }
}
