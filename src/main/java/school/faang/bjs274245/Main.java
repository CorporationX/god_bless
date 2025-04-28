package school.faang.bjs274245;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static void main(String[] args) {
        final int NUM_THREADS = 5;
        final int NUM_VIDEOS = 5;

        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "видео " + i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    manager.addView(videoId);
                    System.out.println("Новый просмотр у " + videoId + ". Текущее кол-во просмотров " +
                            manager.getViewCount(videoId));
                });
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
