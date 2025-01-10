package faang.school.godbless.sprint_3.task_49322;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS  = 10;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_" + (i + 1);
            for (int j = 0; j < NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Video ID — " + videoId
                            + ", view count — " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All tasks completed");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
