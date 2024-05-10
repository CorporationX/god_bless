package faang.school.godbless.sprint3.BJS2_6318;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREADS_COUNT = 100;
    private static final int VIDEOS_COUNT = 10;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_COUNT);

        for (int i = 0; i < VIDEOS_COUNT; i++) {
            final String videoId = "video" + i;
            for (int j = 0; j < THREADS_COUNT / VIDEOS_COUNT; j++) {
                executor.execute(() -> {
                    manager.addView(videoId);
                    System.out.println("Video " + videoId + " has " + manager.getViewCount(videoId) + " views.");
                });
            }
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException exception) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
