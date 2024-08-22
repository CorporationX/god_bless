package faang.school.godbless.BJS2_24339;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        List<String> videos = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        int NUM_THREADS = 100;
        int NUM_VIDEOS = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            int currentVideo = i;
            for (int j = 0; j < NUM_THREADS/NUM_VIDEOS; j++) {
                executorService.execute(() -> {
                    videoManager.addView(videos.get(currentVideo));
                    String currentThread = Thread.currentThread().getName();
                    System.out.printf("%s: Количество просмотров у видео № %s: %d%n",
                            currentThread, videos.get(currentVideo), videoManager.getViewCount(videos.get(currentVideo)));
                });
            }
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        videoManager.printViewMap();
    }
}
