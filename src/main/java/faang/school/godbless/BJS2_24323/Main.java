package faang.school.godbless.BJS2_24323;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                final String videoId = "video" + i;
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Текущие просмотры для " + videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }


    }
}
