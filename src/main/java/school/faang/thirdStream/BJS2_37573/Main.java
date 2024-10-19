package school.faang.thirdStream.BJS2_37573;

import com.github.javafaker.Faker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        final int THREADS_PER_VIDEO = NUM_THREADS / NUM_VIDEOS;

        Faker faker = new Faker();

        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = faker.lorem().word();

            for (int j = 0; j < THREADS_PER_VIDEO; j++) {
                executor.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Видео %s просмотров: %d%n", videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
