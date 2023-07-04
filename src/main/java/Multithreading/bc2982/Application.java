package Multithreading.bc2982;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Application {
    static final int NUM_THREADS = 100;
    static final int NUM_VIDEOS = 300;

    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();
        List<String> videos = new ArrayList<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            videos.add("Video" + i);
        }
        System.out.println(videos);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (String video : videos) {
            executorService.execute(() -> {
                videoManager.addView(video);
                int count = videoManager.getViewCount(video);
                System.out.println(video + " views: " + count);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                int count = videoManager.getViewCount(video);
                System.out.println(video + " views: " + count);
            });
            executorService.execute(() -> {
                videoManager.addView(video);
                int count = videoManager.getViewCount(video);
                System.out.println(video + " views: " + count);
            });

        }
        executorService.shutdown();
        if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
            System.out.println("Finished");
        }
    }
}
