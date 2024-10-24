package youtube.counter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VideoManager {
    private final Map<String, Integer> viewsMap = new ConcurrentHashMap<>();
    private static final int NUM_THREADS = 50;
    private static final int NUM_VIDEOS = 10;

    public synchronized void addView(String videoId) {
        if (viewsMap.get(videoId) != null) {
            viewsMap.put(videoId, viewsMap.get(videoId) + 1);
        } else {
            viewsMap.put(videoId, 1);
        }
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.get(videoId);
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "New Video " + i;
            for (int j = 0; i < NUM_THREADS / NUM_VIDEOS; j++) {
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
