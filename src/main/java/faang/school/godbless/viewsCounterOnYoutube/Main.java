package faang.school.godbless.viewsCounterOnYoutube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int numThreads = 100;
    private static final int numVideos = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numVideos; i++) {
            String videoId = "videoNumber" + i;
            for (int j = 0; j < (numThreads / numVideos); j++) {
                executorService.submit(() ->
                {
                    videoManager.addView(videoId);
                    System.out.println(videoId + "view counter is: " + videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
