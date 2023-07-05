package faang.school.godbless.kxnvg.youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YouTubeRunner {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        HashMap<String, Integer> viewsMap = new HashMap<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            viewsMap.put("video" + i, 0);
        }

        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                service.execute(() -> videoManager.addView(videoId));
                service.execute(() -> System.out.println(videoId + " = " + videoManager.getViewCount(videoId)));
            }
        }

        service.shutdown();
        try {
            service.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("===   Все задачи завершены   ===");

        for (Map.Entry<String, Integer> entry : videoManager.getViewsMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
