package school.faang.youtubecounter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int NUM_THREADS = 100;
    static final int NUM_VIDEOS = 10;
    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int k = 0; k < NUM_THREADS / NUM_VIDEOS; k++) {
                service.execute(() -> videoManager.addView("Cheking"));
                System.out.println(videoManager.getViewCount("Cheking"));
            }
        }
        service.shutdown();
        service.awaitTermination(5000, TimeUnit.SECONDS);
    }
}
