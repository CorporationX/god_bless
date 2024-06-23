package faang.school.godbless.youTubeViewCounter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 20;

    public static void main(String[] args) throws InterruptedException {

        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<Video> videoList = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videoList.add(new Video(new Random(NUM_VIDEOS) + LocalDateTime.now().toString()));
        }

        videoList.forEach(video -> {
            for (int i = 0; i < NUM_THREADS / NUM_VIDEOS; i++) {
                executorService.submit(() -> {
                    try {
                        videoManager.addView(video);
                        videoManager.getViewCount(video);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        });
        executorService.shutdown();
        if (!executorService.awaitTermination(4, TimeUnit.SECONDS)) {
            System.out.println("Не закрыты задачи");
        } else {
            System.out.println("Все задачи выполнены!");
        }
    }
}