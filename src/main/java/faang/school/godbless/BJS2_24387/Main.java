package faang.school.godbless.BJS2_24387;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static VideoManager videoManager = new VideoManager();

    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 25;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        List<String> videoIds = new ArrayList<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoIds.add("video_" + i + ".mp4");
        }

        for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
            videoIds.forEach(video -> executor.submit(() -> videoOperate(video)));
        }

        try {
            executor.shutdown();
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All videos views");
        for (var entry : videoManager.getViewsMap().entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    private static void videoOperate(String videoId) {
        videoManager.addView(videoId);
        System.out.println(videoId + " current views " + videoManager.getViewCount(videoId));
    }
}

