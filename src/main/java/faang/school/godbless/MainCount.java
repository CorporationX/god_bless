package faang.school.godbless;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainCount {
    private final static int NUM_THREADS = 20;
    private final static int NUM_VIDEOS = 5;
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        Map<String, Integer> viewsMap = new HashMap<>();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            viewsMap.put("video " + i, 0);
        }

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoID = "video" + i;
            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                executor.execute(() -> videoManager.addView(videoID));
                executor.execute(() -> System.out.println(videoID + " = " + videoManager.getViewCount(videoID)));
            }
        }
        executor.shutdown();

        try{
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads complete work !");

        for (Map.Entry<String, Integer> entry : videoManager.getViewsMap().entrySet()) {
            System.out.println(entry.getKey() + " have " + entry.getValue() + " views !");
        }
    }
}
