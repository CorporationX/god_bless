package faang.school.godbless.BJS2_1305;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        int NUM_THREADS = 100;
        int NUM_VIDEOS = 40;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Video id = "+i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    int numOfViews = videoManager.getViewCount(videoId);
                    System.out.println(videoId+" has "+numOfViews+" views");
                });
            }
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);
    }
}
