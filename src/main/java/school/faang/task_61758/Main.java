package school.faang.task_61758;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 10;
    public static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            final String videoId = "video " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                Runnable task = () -> {
                    videoManager.addView(videoId);
                    System.out.printf("Video %s кол-во просмотров: %d%n",
                            videoId, videoManager.getViewCount(videoId));
                };
                executorService.submit(task);
            }
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            System.out.println("Поток прерван!" + e);
        }
    }
}
