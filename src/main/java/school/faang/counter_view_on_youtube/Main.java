package school.faang.counter_view_on_youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int numThreads = 5;
        final int numVideos = 100000;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numVideos; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < numThreads; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video " + videoId + " просмотров: " + videoManager.getViews(videoId));
                });
            }
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
