package faang.school.godbless.synchronizationWaitNotify.YouTubeViewsCounter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            map.put("id" + i, 0);
        }
        VideoManager videoManager = new VideoManager(map);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String videoId = "id" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.printf("Поток: %s. Количество просмотров у видео %s равно: %d\n",
                            Thread.currentThread().getName(), videoId, videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }
}
