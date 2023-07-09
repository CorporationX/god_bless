package faang.school.godbless.sprint4.multithreading_synchronization_wait_notify.task8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUM_VIDEOS = 100;

    private static final int NUM_THREADS = 5;


    public static void main(String[] args) throws InterruptedException {
        VideoManager videoManager = new VideoManager();

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_VIDEOS; i++) {
            String videoName = "video " + i;
            executor.execute(() -> videoManager.addView(videoName));
            executor.execute(() -> videoManager.getViewCount(videoName));
        }

        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
        }

        System.out.println("Done!");
    }
}
