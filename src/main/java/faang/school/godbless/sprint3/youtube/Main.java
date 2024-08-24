package faang.school.godbless.sprint3.youtube;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int NUM_THREADS = 10000;
    private static final int NUM_VIDEOS = 100;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        IntStream.rangeClosed(1, NUM_THREADS).forEach(numOfThread -> executor.execute(() -> {
            int video = new Random().nextInt(1, NUM_VIDEOS);
            videoManager.addView(String.valueOf(video));
            System.out.printf("Видео %s - %d просмотров%n", video, videoManager.getViewCount(String.valueOf(video)));
        }));
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
