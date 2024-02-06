package YouTube;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int NUM_VIDEOS = 3;
        int NUM_THREADS = 1000;

        List<Video> videoList = new ArrayList<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoList.add(new Video());
        }

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            executorService.submit(() -> videoManager.getViewsCount((int) (Math.random() * NUM_VIDEOS)));
            executorService.submit(() -> videoManager.addView((int) (Math.random() * NUM_VIDEOS)));
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
