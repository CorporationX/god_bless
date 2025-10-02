package school.faang.bjs290285;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoManager {

    private static final int NUM_THREADS = 100;  //количество потоков
    private static final int NUM_VIDEOS = 8; //количество видео

    private Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new ConcurrentHashMap<>();
    }

    public synchronized void addView(String viewId) {
        viewsMap.merge(viewId, 1, Integer::sum);
    }

    public synchronized int getViewCount(String viewId) {
        return viewsMap.getOrDefault(viewId, 0);
    }

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int j = 0; j < NUM_VIDEOS; j++) {
            int finalJ = j;
            for (int i = 0; i < NUM_THREADS; i++) {
                executorService.execute(() -> {
                    String videoId = "video" + finalJ;
                    videoManager.addView(videoId);
                });
            }
        }

        // Завершение работы пула потоков после завершения всех задач
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Пример получения количества просмотров для конкретного видео
        System.out.println("Views for video0: " + videoManager.getViewCount("video0"));
    }
}
