package school.faang.youTubeviewcounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Видео " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Видео: %s\nПросмотров: %d\n\n",
                            videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
