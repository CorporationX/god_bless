package faang.school.godbless.BJS2_24417;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class YouTube {
    public static void main(String[] args) {
        var videoManager = new VideoManager();
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 10;
        createVideo(videoManager.getViewsMap(), NUM_VIDEOS);

        var executorService = Executors.newFixedThreadPool(NUM_THREADS);

        videoManager.getViewsMap().forEach(
                (s, integer) -> executorService.execute(() -> {
                    for (int i = NUM_THREADS / NUM_VIDEOS; i > 0; i--) {
                        videoManager.addView(s);
                        var videoCount = videoManager.getVideoCount(s);
                        System.out.printf("%s has %d views\n", s, videoCount);
                    }
                })
        );

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES))
                System.out.println("All tasks completed");
            else {
                var tasks = executorService.shutdownNow();
                tasks.forEach(task -> System.out.printf("Task %s wasn't ended%n", task));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
    }

    private static void createVideo(Map<String, Integer> videoMap, int numVideos) {
        for (int i = 0; i < numVideos; ++i) {
            videoMap.put("Video #" + i, 0);
        }
    }
}