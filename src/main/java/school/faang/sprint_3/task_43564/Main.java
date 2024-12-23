package school.faang.sprint_3.task_43564;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int TIMEOUT = 2;
    private static final int INITIAL_VIEWS = 0;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "Видео " + i;
            videoManager.getViews().put(videoId, INITIAL_VIEWS);
        }

        videoManager.getViews().keySet().forEach(
                key -> {
                    for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                        executor.execute(() -> videoManager.addView(key));
                        executor.execute(() -> videoManager.getViewCount(key));
                    }
                }
        );

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
