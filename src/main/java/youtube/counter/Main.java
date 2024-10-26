package youtube.counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    public static void main(String[] args) {

        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            final String videoId = "New Video " + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                service.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println(videoId + " кол-во просмотров " + videoManager.getViewCount(videoId));
                });
            }
        }
        service.shutdown();
        try {
            if (service.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("Все задачи завершены.");
            } else {
                System.out.println("Задачи не завершены.");
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
