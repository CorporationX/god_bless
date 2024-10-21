package school.faang.synchronization.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.submit(() -> {
                    videoManager.addView(videoId); // Добавляем просмотр
                    System.out.println("Video " + videoId + " views: " + videoManager.getViewCount(videoId));
                });
            }
        }
        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
