package faang.school.godbless.multithreading.youtube;

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
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String video = "Video-" + (i + 1);
            videoManager.getViewsMap().put(video, 0);

            for (int j = 0; j < NUM_THREADS / NUM_VIDEOS; j++) {
                threads.add(new Thread(() -> {
                    videoManager.addView(video);
                    System.out.printf("Views: %d for video: %s | Thread: %s\n",
                            videoManager.getViewCount(video), video, Thread.currentThread().getName());
                }));
            }
        }

        threads.forEach(executor::execute);

        executor.shutdown();
        executor.awaitTermination(1000, TimeUnit.SECONDS);
    }
}
