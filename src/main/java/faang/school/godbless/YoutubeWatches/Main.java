package faang.school.godbless.YoutubeWatches;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 20;
        final int NUM_VIDEOS = 10;
        VideoManager videoManager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videosId = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + i;
            videosId.add(videoId);
        }

        for (String videoId : videosId) {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executor.execute(() -> {
                    videoManager.addView(videoId + " " + videoManager.getViewCount(videoId));
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)){
                System.out.println("Waiting for threads to finish");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

