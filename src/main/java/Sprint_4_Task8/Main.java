package Sprint_4_Task8;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int NUM_VIDEOS = 100;

    @SneakyThrows
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoName = "video " + i;
            executorService.execute(() -> videoManager.addView(videoName));
            executorService.execute(() -> videoManager.getViewCount(videoName));
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Done!");
    }
}
