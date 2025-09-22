package school.faang.scoretube;

import org.slf4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static Logger log;

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        final int NUM_THREADS = 5;
        final int NUM_VIDEOS = 100;
        final int MAX_WAIT_MINUTES = 5;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            int finalI = i;
            for (int j = 0; j < NUM_THREADS; j++) {
                executor.submit(() -> {
                    videoManager.addView("video" + finalI);
                    System.out.println("Video " + finalI + " viewed");
                });
            }
            executor.shutdown();

            try {
                if (!executor.awaitTermination(MAX_WAIT_MINUTES, TimeUnit.MINUTES)) {
                    log.info("Не все задачи завершены за {} минут. Завершаем принудительно...", MAX_WAIT_MINUTES);
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                log.error("Ожидание завершения потоков прервано.");
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }

            for (int x = 0; x < NUM_VIDEOS; x++) {
                String videoId = "video" + x;
                System.out.println(videoId + " total views: " + videoManager.getVideoCount(videoId));
            }
        }
    }
}
