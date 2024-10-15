package school.faang.multithreading.synchron.views.counter.youtube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private final static int NUM_THREADS = 100;
    private final static int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String newVideo = "video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.submit(() -> {
                    videoManager.addView(newVideo);
                    System.out.println("Количество просмотров: " + videoManager.getViewCount(newVideo) + " у видео: " + newVideo);
                });
            }
        }

        service.shutdown();
        if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
            service.shutdownNow();
        }
    }
}
