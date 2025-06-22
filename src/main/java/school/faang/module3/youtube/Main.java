package school.faang.module3.youtube;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 4;
    private static final int NUM_VIDEOS = 15;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        Set<String> videoIds = new HashSet<>();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_VIDEOS; i++) {
            for (int j = 0; j < NUM_THREADS; j++) {
                String videoId = "VIDEO" + i;
                videoIds.add(videoId);
                executor.execute(() -> manager.addView(videoId));
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("time out. force shutdown");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        videoIds.stream()
                .forEach((videoId) -> {
                    System.out.printf("videoId: \"%s\", view count = %d\n", videoId, manager.getViewCount(videoId));
                });
    }
}
