package youtube_views;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 100;
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String id = Integer.toString(i);
            videoManager.getViewsMap().put(id, 0);
        }

        for (Map.Entry<String, Integer> entry : videoManager.getViewsMap().entrySet()) {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(String.valueOf(entry.getKey()));
                    System.out.println("Video " + entry.getKey() + ": Views = " + videoManager.getViewCount(String.valueOf(entry.getKey())));
                });
            }
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Не удалось дождаться завершения всех задач в течение 10 секунд.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
