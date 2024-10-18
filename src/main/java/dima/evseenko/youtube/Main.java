package dima.evseenko.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 100;
    private static final int VIDEOS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < VIDEOS_COUNT; i++) {
            String video = "Video" + i + ".mp4";
            for (int j = 0; j < THREADS_COUNT / VIDEOS_COUNT; j++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    System.out.printf("Video - %s, views - %s%n", video, videoManager.getViewCount(video));
                });
            }
        }

        executorService.shutdown();

        if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
            System.out.println(videoManager.getViewsMap());
        }
    }
}
