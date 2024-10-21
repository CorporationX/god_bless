package school.faang.counterViews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREAD = 100;
        final int NUM_VIDEOS = 10;

        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREAD / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Видео: " + videoId + ", просмотров: " +
                            videoManager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
