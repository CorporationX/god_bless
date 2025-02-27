package school.faang.youtube_view_counter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int NUM_THREADS = 3;
    public static final int NUM_VIDEO = 50;

    public static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUM_THREADS);

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> viewsMap = new HashMap<>();

        VideoManager videoManager = new VideoManager(viewsMap);

        for (int i = 1; i <= NUM_VIDEO; i++) {
            String videoId = String.valueOf(i);
            viewsMap.put(videoId, 0);
            for (int j = 1; j <= NUM_THREADS; j++) {
                Thread thread = new Thread(() -> {
                    videoManager.addView(videoId);
                    System.out.println("У видео " + videoId + " " + videoManager.getViewCount(videoId) + " просмотров");
                });
                EXECUTOR.execute(thread);
            }
        }
        EXECUTOR.shutdown();
        EXECUTOR.awaitTermination(2, TimeUnit.SECONDS);
        EXECUTOR.shutdownNow();

        for (int i = 1; i <= NUM_VIDEO; i++) {
            String videoId = String.valueOf(i);
            System.out.println("У видео " + videoId + " " + videoManager.getViewCount(videoId) + " просмотров");
        }
    }
}
