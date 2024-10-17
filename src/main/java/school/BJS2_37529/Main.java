package school.BJS2_37529;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_THREADS = 100;
    private static final int NUM_VIDEOS = 10;

    public static void main(String[] args) throws InterruptedException {

        VideoManager videoManager = new VideoManager();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        List<String> videos = new ArrayList<>();
        for (int i = 0; i < NUM_VIDEOS; i++) {
            videos.add("Видео с котиками номер " + i);
        }

        for (String video : videos) {
            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    try {
                        videoManager.addView(video);
                        videoManager.getViewCount(video);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

}
