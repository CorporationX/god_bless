package faang.school.godbless.counterYoutube;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class VideoManager {
    private final Map<String, Integer> viewsMap;

    public VideoManager() {
        this.viewsMap = new HashMap<>();
    }

    public synchronized void addView(String videoId) {
        int views = viewsMap.getOrDefault(videoId, 0);
        viewsMap.put(videoId, views + 1);
    }

    public synchronized int getViewCount(String videoId) {
        return viewsMap.getOrDefault(videoId, 0);
    }

    public static void main(String[] args) throws InterruptedException {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i < NUM_VIDEOS; i++) {
            String videoId = "video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Counting views for " + videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();
        boolean tasksCompleted = executorService.awaitTermination(10, TimeUnit.SECONDS);

        if (tasksCompleted) {
            System.out.println("All tasks completed");
        } else {
            System.out.println("Some tasks didn't complete within specified time");
        }
    }
}
