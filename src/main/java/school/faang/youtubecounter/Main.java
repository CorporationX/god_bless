package school.faang.youtubecounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();

        int NUM_THREADS = 100;
        int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoId = 0; videoId < NUM_VIDEOS; videoId++) {
            String video = "Video" + videoId;
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    System.out.println("Количество просмотров для " + video + ": " + videoManager.getViewCount(video));
                });
            }
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
