package faang.school.godbless.BJS2_12825;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    static final int NUM_THREADS = 100;
    static final int NUM_VIDEOS = 50;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoId = "video_number_" + (i + 1);
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(videoId);
                    System.out.println("Видео " + videoId + " Количество просмотров = " + videoManager.getViewCount(videoId));
                });
            }
        }

        executorService.shutdown();

        if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Потоки завершили работу");
        }
    }
}
