package school.faang.bjs249312;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUM_TREADS = 100;
    private static final int NUM_VIDEOS = 10;
    private static final int AWAIT_WORK_THREAD_POOL = 5;

    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TREADS);

        for (int i = 1; i <= NUM_VIDEOS; i++) {
            String video = "Video " + i;
            for (int j = 0; j < NUM_TREADS / NUM_VIDEOS; j++) {
                executorService.submit(() -> {
                    videoManager.addView(video);
                    System.out.println(video + ", views: " + videoManager.getViewCounter(video));
                });
            }
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAIT_WORK_THREAD_POOL, TimeUnit.SECONDS)) {
                System.out.println("Not all task were completed on time");
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " is interrupted in await time");
            e.printStackTrace();
        }
    }
}
