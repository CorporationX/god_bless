package faang.school.godbless.BJS2_1271;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUM_THREADS = 200;
    public static final int NUM_VIDEOS = 50;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        videoManager.initialize(NUM_VIDEOS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                Video video = videoManager.getVideos().get(i);
                executor.submit(() -> {
                    videoManager.addView(video);
                    System.out.println("video " + video + " has " + videoManager.getViewCount(video) + " views");
                });
            }
        }
        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.SECONDS);

        boolean isAnyNone4 = videoManager.getViewsMap().entrySet().stream().anyMatch(entry -> entry.getValue() != 4);
        System.out.println(isAnyNone4);
    }
}