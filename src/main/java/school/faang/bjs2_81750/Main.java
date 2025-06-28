package school.faang.bjs2_81750;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int numberOfThreads = 15;
        final int numberOfVideos = 7;
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfVideos; i++) {
            for (int j = 0; j < numberOfThreads; j++) {
                String videoId = "/video" + i;
                executorService.execute(() -> videoManager.addView(videoId));
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
