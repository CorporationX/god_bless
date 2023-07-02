package faang.school.godbless.youtube;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Youtube {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 50;

        Map<String, Integer> videosMap = getVideosMap(NUM_VIDEOS);
        VideoManager videoManager = new VideoManager(videosMap);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (String videoId : videosMap.keySet()) {
            for (int i = 0; i < NUM_THREADS/NUM_VIDEOS; i++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    videoManager.getViewCount(videoId);
                });
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(100, TimeUnit.SECONDS)) {
                System.out.println("Done!");
            } else {
                System.out.println("Time has expired!");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Integer> getVideosMap(int count) {
        Map<String, Integer> videos = new HashMap<>();

        for (int i = 0; i < count; i++) {
            videos.put("video #" + i, 0);
        }

        return videos;
    }


}
