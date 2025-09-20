package school.faang.bjs2_90080;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 5;
    private static final int NUM_VIDEOS = 10;
    private static final long TIMEOUT = 30;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    public static void main(String[] args) {
        VideoManager manager = new VideoManager();
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int videoId = 1; videoId <= NUM_VIDEOS; videoId++) {
            final String currentVideoId = "video" + videoId;

            for (int i = 0; i < NUM_THREADS; i++) {
                Runnable task = () -> {
                    manager.addView(currentVideoId);
                };
                executor.execute(task);
            }
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TIME_UNIT)) {
                System.out.printf("Задачи не завершились за %d %s%n", TIMEOUT, TIME_UNIT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Ожидание прервано");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        for (int videoId = 1; videoId <= NUM_VIDEOS; videoId++) {
            String video = "video" + videoId;
            int views = manager.getViewCount(video);
            System.out.printf("%s: %d просмотров%n", video, views);
        }
    }
}
