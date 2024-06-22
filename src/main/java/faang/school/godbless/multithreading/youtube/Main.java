package faang.school.godbless.multithreading.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video_" + (i % 3);
            executor.submit(() -> {
                videoManager.addView(video);
                System.out.println("Кол-во просмотров видео " + video + " для потока " + Thread.currentThread().getName()
                        + ": " + videoManager.getViewCount(video));
            });
        }

        executor.shutdown();
        try {
            boolean isTerminated = executor.awaitTermination(1, TimeUnit.MINUTES);
            System.out.println("Потоки завершились: " + isTerminated);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
