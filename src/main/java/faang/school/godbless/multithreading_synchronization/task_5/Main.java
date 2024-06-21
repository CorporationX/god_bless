package faang.school.godbless.multithreading_synchronization.task_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;
    private static final int AWAIT_TERMINATION = 5;

    public static void main(String[] args) {
        final VideoManager videoManager = new VideoManager();
        final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                final String videoId = String.valueOf(i);
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    int currentVideoViews = videoManager.getViewCount(videoId);
                    System.out.printf("Video with id: %s has %d\n", videoId, currentVideoViews);
                });
            }
        }
        try {
            executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while waiting for termination", e);
        }
        executor.shutdown();
    }
}
