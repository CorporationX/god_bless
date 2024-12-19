package school.faang.task_49303;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video" + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.execute(() -> videoManager.addVideo(video));
                Thread.sleep(100);
                executor.execute(() -> videoManager.getViewCount(video));
            }
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                System.out.println("All videos have been added");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
