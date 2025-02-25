package school.faang.BJS2_61729;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 3;
    private static final int TIMEOUT = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int videoIndex = 0; videoIndex < NUM_VIDEOS; videoIndex++) {
            String videoId = "Video" + videoIndex;
            for (int threadIndex = 0; threadIndex < NUM_THREADS; threadIndex++) {
                executor.submit(() -> videoManager.addView(videoId));
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                System.out.print("Потоки не завершились вовремя.\n");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.printf("Произошло прерывание потоков. Причина: %s\n", e.getMessage());
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }
        String videoId = "Video1";
        System.out.printf("Кол-во просмотров %s - %d\n", videoId, videoManager.getViewCount(videoId));
    }
}
