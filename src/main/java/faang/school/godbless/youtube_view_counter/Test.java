package faang.school.godbless.youtube_view_counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    private static final int NUM_THREADS = 56;
    private static final int NUM_VIDEOS = 4;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 1; i < NUM_VIDEOS + 1; i++) {
            String videoId = "Video" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Количество просмотров у " + videoId + ": " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        System.out.println(videoManager.viewsMap);
    }
}
