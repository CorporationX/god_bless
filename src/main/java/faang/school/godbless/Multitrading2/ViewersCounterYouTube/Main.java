package faang.school.godbless.Multitrading2.ViewersCounterYouTube;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 5;


    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            Video video = new Video(i);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(video);
                    System.out.println(video + ": " + videoManager.getViewCount(video));
                });
            }
        }
        int allViews = videoManager.getViewsMap()
                .values()
                .stream()
                .mapToInt(integer -> integer)
                .sum();
        System.out.println(allViews);

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
