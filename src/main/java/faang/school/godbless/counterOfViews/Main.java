package faang.school.godbless.counterOfViews;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        final int NUM_THREADS = 100;
        final int NUM_VIDEOS = 3;
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager manager = new VideoManager();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoID = "видео №" + i;
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executor.submit(() -> {
                    manager.addView(videoID);
                    System.out.println("Количество просмотров: " + manager.getViewCount(videoID));
                });
            }
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(2, TimeUnit.SECONDS)) {
                System.out.println("Все задачи завершены");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
