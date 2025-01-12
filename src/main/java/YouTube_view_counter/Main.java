package YouTube_view_counter;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    @SneakyThrows
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "video" + i;

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    videoManager.addView(video); // Добавляем просмотр
                    System.out.println(video + " = " + videoManager.getViewCount(video));
                });
            }
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
