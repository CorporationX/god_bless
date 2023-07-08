package faang.school.godbless.multithreading.synchronized_wait_notify.youtube_view_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 500;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videoManager.getViewsMap().put(Integer.toString(i), 0);
        }

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            for (int j = 1; j <= NUM_THREADS / NUM_VIDEOS; j++) {
                int videoId = i;
                executor.execute(() -> {
                    videoManager.addView(Integer.toString(videoId));
                    try {
                        System.out.println("video id : " + videoId + " - views :" + videoManager.getViewCount(Integer.toString(videoId)));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                });
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(videoManager.getViewsMap());

    }
}
