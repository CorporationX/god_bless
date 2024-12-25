package school.faang.viewscounter_youtube;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        VideoManager videoManager = new VideoManager();

        List<String> videos = new ArrayList<>();
        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String video = "Video " + i;
            videoManager.addNewVideo(video);
            videos.add(video);
        }
        videos.forEach(video -> {
            for (int i = 1; i <= NUM_THREADS / NUM_VIDEOS; i++) {
                executor.submit(() -> {
                    videoManager.addView(video);
                    System.out.println(video + " has " + videoManager.getViewCount(video) + " views");
                });
            }
        });
        executor.shutdown();
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Mission complete");
            } else {
                System.out.println("Something went wrong..");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
