package school.faang.bjs273747;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int FIXED_POOL_SIZE = 20;
    private static final int NUMBER_OF_VIDEOS = 10;
    private static final int WAIT_TIME = 1;

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_POOL_SIZE);

        for (int i = 0; i < NUMBER_OF_VIDEOS; i++) {
            String videoId = String.format("Video-%d", i);
            for (int j = 0; j < FIXED_POOL_SIZE; j++)
                executorService.submit(() -> videoManager.addView(videoId));
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(WAIT_TIME, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < NUMBER_OF_VIDEOS; i++) {
            String videoId = "Video-" + i;
            System.out.printf("%s have %d views, \n", videoId, videoManager.getView(videoId));
        }
    }
}