package school.faang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Integer NUM_THREADS = 100;
        final Integer NUM_VIDEOS = 10;

        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_VIDEOS; j++) {
                int finalJ = j + 1;
                executor.execute(() -> {
                    String videoID = "видео номер " + finalJ;
                    videoManager.addView(videoID);
                    System.out.println(videoID + " имеет " +
                        videoManager.getViewCount(videoID) + " просмотров");
                });
            }
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);


    }
}
