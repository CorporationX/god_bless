package school.faang.BJS2_37596;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 100;
    public static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addVie(videoId);
                    System.out.println(
                                    "Видео: " +
                                    videoId +
                                    " просмотры: " +
                                    videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();
        executor.awaitTermination(90, TimeUnit.SECONDS);
    }
}
