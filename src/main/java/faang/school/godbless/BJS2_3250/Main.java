package faang.school.godbless.BJS2_3250;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_VIDEOS = 100;
    private static final int THREADS_PER_VIDEO = 100;
    private static final int NUM_THREADS = NUM_VIDEOS * THREADS_PER_VIDEO;


    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            videoManager.addVideo(videoId);
            System.out.println(videoId + " added");
            for (int j = 0; j < THREADS_PER_VIDEO; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println(videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
