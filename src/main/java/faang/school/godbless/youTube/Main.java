package faang.school.godbless.youTube;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 3;

    public static void main(String[] args) {
        Map<Video, Integer> viewsMap = new HashMap<>();
        VideoManager videoManager = new VideoManager(viewsMap);

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            Video video = new Video(generateUUid());
            viewsMap.put(video, 0);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                new Thread(() -> {
                    videoManager.addView(video.getId());
                    System.out.println("Total views of " + video.getId() + " - " + videoManager.getViewCount(video.getId()));
                }).start();
            }

        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static String generateUUid() {
        return UUID.randomUUID().toString();
    }

}
