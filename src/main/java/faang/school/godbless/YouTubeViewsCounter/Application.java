package faang.school.godbless.YouTubeViewsCounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    private static final int NUM_THREADS = 100;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        videoManager.init();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (Integer videoID : videoManager.getViewsMap().keySet()) {
            executor.execute(() -> {
                videoManager.addView(videoID);
                System.out.println("videoID " + videoID + " " + videoManager.getViewCount(videoID));
            });
            executor.execute(() -> {
                videoManager.addView(videoID);
                System.out.println("videoID " + videoID + " " + videoManager.getViewCount(videoID));
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
